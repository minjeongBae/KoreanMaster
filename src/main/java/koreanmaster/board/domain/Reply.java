package koreanmaster.board.domain;

import koreanmaster.board.dao.ReplyDAO;
import koreanmaster.board.dto.PostDTO;
import koreanmaster.board.dto.ReplyDTO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
    private PostDTO post;
    private ReplyDTO reply;
    public Reply(PostDTO post){
        this.post = post;
    }
    public void register(String content) throws SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());

        ReplyDAO replyDAO = new ReplyDAO();
        replyDAO.upload("관리자", content, date);

        reply = new ReplyDTO(replyDAO.getLastRegistered(), "관리자", date, content);
    }
}
