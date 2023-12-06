package koreanmaster.home.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import koreanmaster.board.dao.PostDAO;
import koreanmaster.board.dto.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/my_page")
    public String myPage() {
        return "my-page";
    }

    @GetMapping("/show_board")
    public String showBoard(Model model) throws SQLException {
        List<PostDTO> posts = new PostDAO().allPosts();
        model.addAttribute("posts",posts);
        return "show-board";
    }

    @GetMapping("/board_values")
    public @ResponseBody ResponseEntity<List<PostDTO>> boardValues() throws SQLException, JsonProcessingException {
        List<PostDTO> all = new PostDAO().allPosts();
        return ResponseEntity.ok(all);
    }

}
