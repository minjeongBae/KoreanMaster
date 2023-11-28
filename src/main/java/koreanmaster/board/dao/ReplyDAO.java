package koreanmaster.board.dao;

import koreanmaster.ExecuteSql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplyDAO {
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final ExecuteSql executeSql;

    public ReplyDAO() throws SQLException {
        executeSql = new ExecuteSql();
    }
    public void replyToBoard(String content, int boardId) throws SQLException {
        String date = dateFormat.format(new Date());
        String sql = "INSERT INTO Reply VALUES (NULL, \"관리자\", \""
                + date + "\",\""+content+"\");";
        executeSql.noResult(sql);

        sql = "SELECT reply_id AS LAST_VALUE_OVER FROM Reply;";
        ResultSet rs = executeSql.getResult(sql);
        int replyId = -1;
        while (rs.next()){
            replyId = Integer.parseInt(rs.getString(1));
        }

        sql = "UPDATE Board SET reply_id = "
                + replyId + " WHERE board_id = "
                + boardId + ";";
        executeSql.noResult(sql);
    }
}
