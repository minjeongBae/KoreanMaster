package koreanmaster.home.controller;

import koreanmaster.board.post.PostDto;
import koreanmaster.board.post.service.Show;
import koreanmaster.home.user.dao.UserDAO;
import koreanmaster.teachers.teacher.dao.IntroductionDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/my_page")
    public String myPage(HttpSession session, Model model) throws SQLException {
        if (session.getAttribute("userEmail") == null) return "not-user";
        String userEmail = (String) session.getAttribute("userEmail");
        model.addAttribute("email", userEmail);
        if(new UserDAO().isStudent(userEmail)) {
            model.addAttribute("isStudent", true);
            return "my-page";
        }
        model.addAttribute("isStudent",false);
        return "my-page";
    }

    @GetMapping("/show_board")
    public String showBoard(HttpSession session, Model model) {
        model.addAttribute("signIn","false");
        if(session.getAttribute("userEmail")!=null) model.addAttribute("signIn","true");

        List<PostDto> posts = new Show().getAll();
        model.addAttribute("posts", posts);
        return "show-board";
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
}
