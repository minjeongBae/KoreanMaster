package koreanmaster.board.post.reply.service;

import koreanmaster.board.post.reply.dao.Select;
import koreanmaster.board.post.reply.ReplyDto;

import java.sql.SQLException;

public class Show {
    private final int replyId;

    public Show(int replyId) {
        this.replyId = replyId;
    }

    public ReplyDto run() throws SQLException {
        Select selectTool = new Select();
        return selectTool.get(this.replyId);
    }
}
