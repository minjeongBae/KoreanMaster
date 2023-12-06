package koreanmaster.board.controller;

import koreanmaster.board.dao.PostDAO;
import koreanmaster.board.dto.PostDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class BoardController {

    @GetMapping("/post")
    public String showPost(HttpServletRequest rq, Model model) throws SQLException {
        System.out.println(rq.getParameter("postId"));
        PostDTO post = new PostDAO().getByPostId(Integer.parseInt(rq.getParameter("postId")));
        model.addAttribute("post",post);
        return "show-post";
    }

    @GetMapping("/upload_post")
    public String uploadPost(){
        return "upload-post";
    }

    @GetMapping("/upload_reply")
    public String uploadReply(){
        return "upload-reply";
    }
}
