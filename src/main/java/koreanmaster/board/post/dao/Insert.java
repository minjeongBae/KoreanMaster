package koreanmaster.board.post.dao;

import koreanmaster.common.Dao;
import koreanmaster.board.post.PostDTO;

import java.sql.SQLException;

public class Insert extends Dao {
    public Insert() throws SQLException {
    }

    public void upload(PostDTO post) {
        String sql = "INSERT INTO Post VALUES (NULL, \""
                + post.getTitle() + "\", \"" + post.getWriter() + "\", \""
                + post.getRegistrationDate() + "\", \"" + post.getContent() + "\",NULL);";
        executeSql.noResult(sql);
    }
}
