package koreanmaster.board.post.dao;

import koreanmaster.board.CommonDao;
import koreanmaster.board.post.PostDto;

import java.sql.SQLException;

public class Insert extends CommonDao {
    public Insert() throws SQLException {
    }

    public void upload(PostDto post) {
        String sql = "INSERT INTO Post VALUES (NULL, \""
                + post.getTitle() + "\", \"" + post.getWriter() + "\", \""
                + post.getRegistrationDate() + "\", \"" + post.getContent() + "\",NULL);";
        executeSql.noResult(sql);
    }
}
