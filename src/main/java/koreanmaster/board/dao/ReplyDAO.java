package koreanmaster.board.dao;

import koreanmaster.board.dto.ReplyDTO;
import koreanmaster.common.ExecuteSql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ReplyDAO {
    private final ExecuteSql executeSql;

    public ReplyDAO() throws SQLException {
        executeSql = new ExecuteSql();
    }
    public void upload(String writer, String content, String date) throws SQLException {
        String sql = "INSERT INTO Reply VALUES (NULL, \""+writer+"\", \""
                + date + "\",\""+content+"\");";
        executeSql.noResult(sql);
    }

    public int getLastRegistered() throws SQLException {
        String sql = "SELECT reply_id AS LAST_VALUE_OVER FROM Reply;";
        ResultSet rs = executeSql.getResult(sql);
        int replyId = -1;
        while (rs.next()){
            replyId = Integer.parseInt(rs.getString(1));
        }

        return replyId;
    }

    public void revise(int replyId, String content, String date) throws SQLException {
        String sql = "UPDATE Reply SET content = \"" + content
                + "\", registration_date = \"" + date +
                "\" WHERE reply_id = " + replyId + ";";
        executeSql.noResult(sql);
    }

    public ReplyDTO getReply(int replyId) throws SQLException {
        String sql = "SELECT * FROM Reply WHERE = " + replyId + ";";
        ResultSet rs = executeSql.getResult(sql);
        while (rs.next()){
            return new ReplyDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            );
        }
        return null;
    }
}
