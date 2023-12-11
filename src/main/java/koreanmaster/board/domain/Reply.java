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
    private final ReplyDAO replyDAO;
    private ReplyDTO reply;

    public Reply(PostDTO post) throws SQLException {
        this.post = post;

        replyDAO = new ReplyDAO();
        if (post != null) {
            int replyId = new PostDAO().getReplyId(post.getPostId());
            reply = replyDAO.getReply(replyId);
        }
    }

    public boolean register(String content, String writer) throws SQLException {
        if (reply != null) return false;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());

        reply = new ReplyDTO(replyDAO.getLastRegistered(), writer, date, content);
        replyDAO.upload(reply);
        return true;
    }

    public boolean revise(String content) throws SQLException {
        if (reply != null) {
            reply.setContent(content);
            replyDAO.revise(reply.getReplyId(), reply.getContent());
            return true;
        }
        return false;
    }

    public boolean remove() throws SQLException {
        if (reply == null) return false;
        replyDAO.remove(reply.getReplyId());
        reply = null;
        return true;
    }

    public boolean isExisting() {
        return reply != null;
    }

    public ReplyDTO getReply() {
        return this.reply;
    }
}
