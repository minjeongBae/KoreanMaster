package koreanmaster.home.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import koreanmaster.board.dao.PostDAO;
import koreanmaster.board.dto.PostDTO;
import koreanmaster.user.teacher.introduction.dao.IntroductionDAO;
import koreanmaster.user.teacher.introduction.dto.IntroductionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/my_page")
    public String myPage(HttpSession session, Model model) {
        if (session.getAttribute("userEmail") == null) return "not-user";
        model.addAttribute("email", session.getAttribute("userEmail"));
        return "my-page";
    }

    @GetMapping("/show_board")
    public String showBoard(HttpSession session, Model model) throws SQLException {
        model.addAttribute("signIn","false");
        if(session.getAttribute("userEmail")!=null) model.addAttribute("signIn","true");
        List<PostDTO> posts = new PostDAO().allPosts();
        model.addAttribute("posts", posts);
        return "show-board";
    }

    @GetMapping("/board_values")
    public @ResponseBody ResponseEntity<List<PostDTO>> boardValues() throws SQLException, JsonProcessingException {
        List<PostDTO> all = new PostDAO().allPosts();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/introduction")
    public String introduction(){
        return "introduction";
    }

    @GetMapping("/teachers")
    public String teachers(Model model) throws SQLException {
        IntroductionDAO introDao = new IntroductionDAO();
        model.addAttribute("introductionDTOList", introDao.getAll());

        return "teachers";
    }

    @GetMapping("/teacher_page")
    public String teacherPage(HttpServletRequest request, Model model) throws SQLException {
        IntroductionDAO introductionDAO = new IntroductionDAO();
        System.out.println(Integer.parseInt(request.getParameter("introduction-id")));
        IntroductionDTO introduction = introductionDAO.getById(Integer.parseInt(request.getParameter("introduction-id")));
        model.addAttribute("introduction", introduction);
        return "teacher-page";
    }
}
