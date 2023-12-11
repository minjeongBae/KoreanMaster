package koreanmaster.home.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import koreanmaster.board.dao.PostDAO;
import koreanmaster.board.dto.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        System.out.println(session.getAttribute("userEmail"));
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

}
