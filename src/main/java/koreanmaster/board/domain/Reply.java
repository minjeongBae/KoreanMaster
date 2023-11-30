package koreanmaster.board.domain;

import koreanmaster.board.dao.PostDAO;
import koreanmaster.board.dao.ReplyDAO;
import koreanmaster.board.dto.PostDTO;
import koreanmaster.board.dto.ReplyDTO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
    private final PostDTO post;
    private ReplyDTO reply;
    public Reply(PostDTO post) throws SQLException {
        this.post = post;

        int replyId = new PostDAO().getReplyId(post.getPostId());
        reply = new ReplyDAO().getReply(replyId);
    }
    public void register(String content, String writer) throws SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());

        ReplyDAO replyDAO = new ReplyDAO();
        replyDAO.upload(writer, content, date);

        reply = new ReplyDTO(replyDAO.getLastRegistered(), writer, date, content);
    }

    public boolean revise(String content) throws SQLException {
        if(reply!=null){
            reply = new ReplyDTO(
                    reply.getReplyId(),
                    reply.getWriter(),
                    reply.getRegistrationDate(),
                    content
            );
            ReplyDAO replyDAO = new ReplyDAO();
            replyDAO.revise(reply.getReplyId(), reply.getContent(), reply.getRegistrationDate());
           return true;
        }
        return false;
    }
}
