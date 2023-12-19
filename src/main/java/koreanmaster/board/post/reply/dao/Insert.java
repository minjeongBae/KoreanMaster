package koreanmaster.board.post.reply.dao;

import koreanmaster.board.CommonDao;
import koreanmaster.board.post.reply.ReplyDto;

import java.sql.SQLException;

public class Insert extends CommonDao {
    public Insert() throws SQLException {
    }

    public void upload(ReplyDto reply) throws SQLException {
        String sql = "INSERT INTO Reply VALUES (NULL, \"" + reply.getWriter() + "\", \""
                + reply.getRegistrationDate() + "\",\""
                + reply.getContent() + "\");";
        executeSql.noResult(sql);
    }
}
