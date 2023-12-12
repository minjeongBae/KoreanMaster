package koreanmaster.board.controller;

import koreanmaster.board.dao.PostDAO;
import koreanmaster.board.service.DateManage;
import koreanmaster.board.service.PostManage;
import koreanmaster.board.service.ReplyManage;
import koreanmaster.board.dto.PostDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BoardController {

    @GetMapping("/post")
    public String showPost(HttpServletRequest rq, Model model) throws SQLException {
        PostDTO post = new PostDAO().getByPostId(Integer.parseInt(rq.getParameter("postId")));
        ReplyManage replyManage = new ReplyManage(post);
        if (replyManage.isExisting()) model.addAttribute("reply", replyManage.getReply());
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

    @PostMapping("/success_upload_post")
    public String successUploadPost(HttpServletRequest rq, HttpSession session) throws SQLException {
        String title = rq.getParameter("title");
        String content = rq.getParameter("content");
        String writer = String.valueOf(session.getAttribute("userEmail"));
        String date = new DateManage().getDate();

        PostManage postManage = new PostManage();
        postManage.registerPost(title, writer, date,content);

        return "success-upload-post";
    }
}
