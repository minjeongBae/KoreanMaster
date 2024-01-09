package koreanmaster.board;

import koreanmaster.board.date.MyFormat;
import koreanmaster.board.post.PostDTO;
import koreanmaster.board.post.reply.ReplyDTO;
import koreanmaster.board.post.service.Show;
import koreanmaster.board.post.service.Upload;
import koreanmaster.home.user.dao.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@org.springframework.stereotype.Controller
public class Controller {
    private final Upload upload;

    @Autowired
    public Controller(Upload upload) {
        this.upload = upload;
    }

    @GetMapping("/post")
    public String showPost(HttpServletRequest rq, HttpSession session, Model model) throws SQLException {
        Show show = new Show(Integer.parseInt(rq.getParameter("postId")));
        model.addAttribute("isLast", show.isLast());

        PostDTO post = show.run();
        model.addAttribute("post", post);

        ReplyDTO reply = show.getReply();
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

    @PostMapping("/success_upload_post")
    public String successUploadPost(HttpServletRequest rq, HttpSession session) {
        String title = rq.getParameter("title");
        String content = rq.getParameter("content");
        String writer = String.valueOf(session.getAttribute("userEmail"));
        String date = new MyFormat().get();

        PostDTO newPost = new PostDTO(0, title, writer, date, content, 0);
        if(upload.run(newPost)) return "success-upload-post";
        return "upload-post";
    }

}
