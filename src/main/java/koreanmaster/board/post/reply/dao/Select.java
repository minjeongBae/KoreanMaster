package koreanmaster.board.post.reply.dao;

import koreanmaster.common.Dao;
import koreanmaster.board.post.reply.ReplyDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends Dao {

    public Select() throws SQLException {
    }

    public ReplyDTO get(int replyId) throws SQLException {
        String sql = "SELECT * FROM Reply WHERE reply_id = " + replyId + ";";
        ResultSet rs = executeSql.getResult(sql);
        if (rs == null) return null;

        ReplyDTO reply = null;
        while (rs.next()) {
            reply = new ReplyDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            );
        }
        return reply;
    }

    public int getTheLast() throws SQLException {
        String sql = "SELECT reply_id AS LAST_VALUE_OVER FROM Reply;";
        ResultSet rs = executeSql.getResult(sql);
        int replyId = -1;

        while (rs.next()) {
            replyId = Integer.parseInt(rs.getString(1));
        }
        return replyId;
    }
}
