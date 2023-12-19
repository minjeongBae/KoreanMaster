package koreanmaster.board.post.reply.dao;

import koreanmaster.board.CommonDao;
import koreanmaster.board.post.reply.ReplyDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends CommonDao {

    public Select() throws SQLException {
    }

    public ReplyDto get(int replyId) throws SQLException {
        String sql = "SELECT * FROM Reply WHERE reply_id = " + replyId + ";";
        ResultSet rs = executeSql.getResult(sql);
        if (rs == null) return null;

        ReplyDto reply = null;
        while (rs.next()) {
            reply = new ReplyDto(
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
