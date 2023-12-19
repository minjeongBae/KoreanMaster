package koreanmaster.board;

import koreanmaster.board.date.MyFormat;
import koreanmaster.board.post.PostDto;
import koreanmaster.board.post.reply.ReplyDto;
import koreanmaster.board.post.service.Show;
import koreanmaster.board.post.service.Upload;
import koreanmaster.home.user.dao.Select;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/post")
    public String showPost(HttpServletRequest rq, HttpSession session, Model model) throws SQLException {
        Show show = new Show(Integer.parseInt(rq.getParameter("postId")));
        model.addAttribute("isLast", show.isLast());

        PostDto post = show.run();
        model.addAttribute("post", post);

        ReplyDto reply = show.getReply();
        if (reply!=null) model.addAttribute("reply", reply);

        String nowUser = (String) session.getAttribute("userEmail");
        if(new Select().isManager(nowUser)) model.addAttribute("isManager",true);

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
    public String showMyPosts(HttpSession session, Model model) {
        Show show = new Show();
        String userEmail = (String) session.getAttribute("userEmail");
        List<PostDto> myPosts = show.getByEmail(userEmail);

        model.addAttribute("myPosts", myPosts);
        model.addAttribute("email", userEmail);
        return "my-page";
    }

    @PostMapping("/success_upload_post")
    public String successUploadPost(HttpServletRequest rq, HttpSession session) {
        String title = rq.getParameter("title");
        String content = rq.getParameter("content");
        String writer = String.valueOf(session.getAttribute("userEmail"));
        String date = new MyFormat().get();

        PostDto newPost = new PostDto(0, title, writer, date, content, 0);
        if(new Upload(newPost).run()) return "success-upload-post";
        return "upload-post";
    }
}
