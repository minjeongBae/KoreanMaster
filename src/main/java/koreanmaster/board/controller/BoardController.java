package koreanmaster.board.controller;

import koreanmaster.board.dao.PostDAO;
import koreanmaster.board.domain.Reply;
import koreanmaster.board.dto.PostDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BoardController {

    @GetMapping("/post")
    public String showPost(HttpServletRequest rq, Model model) throws SQLException {
        PostDTO post = new PostDAO().getByPostId(Integer.parseInt(rq.getParameter("postId")));
        Reply reply = new Reply(post);
        if (reply.isExisting()) model.addAttribute("reply", reply.getReply());
        model.addAttribute("post", post);
        return "show-post";
    }

    @GetMapping("/upload_post")
    public String uploadPost() {
        return "upload-post";
    }

    @GetMapping("/upload_reply")
    public String uploadReply() {
        return "upload-reply";
    }

    @GetMapping("/my_posts")
    public String showMyPosts(HttpSession session, Model model) throws SQLException {
        List<PostDTO> myPosts = new PostDAO().getByEmail(String.valueOf(session.getAttribute("userEmail")));
        model.addAttribute("myPosts", myPosts);
        model.addAttribute("email", session.getAttribute("userEmail"));
        return "my-page";
    }
}
