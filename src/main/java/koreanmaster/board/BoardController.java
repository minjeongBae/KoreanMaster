package koreanmaster.board;

import koreanmaster.board.date.MyFormat;
import koreanmaster.board.post.PostDTO;
import koreanmaster.board.post.reply.ReplyDTO;
import koreanmaster.board.post.reply.service.ShowReply;
import koreanmaster.board.post.service.AddReply;
import koreanmaster.board.post.service.Remove;
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
import java.util.List;

@org.springframework.stereotype.Controller
public class BoardController {
    private final Upload upload;
    private final AddReply addReply;
    private final Remove remove;

    private final Show show;
    private final ShowReply showReply;
    @Autowired
    public BoardController(Upload upload, Remove remove, Show show,
                           AddReply addReply, ShowReply showReply) {
        this.upload = upload;
        this.show = show;
        this.addReply = addReply;
        this.remove = remove;
        this.showReply = showReply;
    }

    @GetMapping("/post")
    public String showPost(HttpServletRequest rq, HttpSession session, Model model) throws SQLException {
        int postId = Integer.parseInt(rq.getParameter("postId"));
        int prevId = -1;
        int nextId = -1;
        if(show.getPrevId(postId)!=null)
            prevId = show.getPrevId(postId);
        if(show.getNextId(postId)!=null)
            nextId = show.getNextId(postId);

        model.addAttribute("prevId", prevId);
        model.addAttribute("nextId", nextId);


        PostDTO post = show.run(postId);
        model.addAttribute("post", post);

        //댓글보여주기
        ReplyDTO reply = showReply.run(post.getReplyId());
        if (reply!=null) model.addAttribute("reply", reply);

        String nowUser = (String) session.getAttribute("userEmail");
        model.addAttribute("nowUser", nowUser);
        if(new Select().isManager(nowUser)) model.addAttribute("isManager",true);

        return "show-post";
    }

    @GetMapping("/upload_post")
    public String uploadPost() {
        return "upload-post";
    }

    @PostMapping("/upload_reply")
    public String uploadReply(HttpServletRequest rq, Model model) {
        model.addAttribute("postId", rq.getParameter("postId"));
        return "upload-reply";
    }

    @PostMapping("/remove_post")
    public String removePost(HttpServletRequest rq, Model m) throws SQLException {
        remove.run(Integer.parseInt(rq.getParameter("postId")));
        m.addAttribute("message","해당 게시글이 삭제되었습니다.");

        m.addAttribute("signIn","true");
        List<PostDTO> posts = new Show().getAll();
        m.addAttribute("posts", posts);

        return "show-board";
    }

    @PostMapping("/success_upload")
    public String successUpload(HttpServletRequest rq, HttpSession session) {
        String content = rq.getParameter("content");
        String date = new MyFormat().get();
        if(rq.getParameter("type").equals("post")){
            String title = rq.getParameter("title");
            String writer = String.valueOf(session.getAttribute("userEmail"));
            PostDTO newPost = new PostDTO(0, title, writer, date, content, 0);
            if(upload.run(newPost)) return "success-upload";
            return "upload-post";
        }

        ReplyDTO newReply = new ReplyDTO(0,"관리자", date, content);
        if(addReply.run(Integer.parseInt(rq.getParameter("postId")),newReply))
            return "success-upload";
        return "upload-reply";
    }

}
