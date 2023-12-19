package koreanmaster.board.post.dao;

import koreanmaster.common.Dao;

import java.sql.SQLException;

public class Delete extends Dao {
    public Delete() throws SQLException {
    }

    public void remove(int postId) {
        String sql = "DELETE FROM Post WHERE post_id = " + postId;
        executeSql.noResult(sql);
    }
}
