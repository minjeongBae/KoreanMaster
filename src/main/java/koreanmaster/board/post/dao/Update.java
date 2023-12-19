package koreanmaster.board.post.dao;

import koreanmaster.common.Dao;

import java.sql.SQLException;

public class Update extends Dao {
    public Update() throws SQLException {
    }

    public void revise(int postId, String content) {
        String sql = "UPDATE Post SET content = \"" + content
                + "\" WHERE post_id = " + postId + ";";
        executeSql.noResult(sql);
    }

    public void addReply(int postId, int replyId) {
        String sql = "UPDATE Post SET reply_id = "
                + replyId + " WHERE post_id = "
                + postId + ";";
        executeSql.noResult(sql);
    }
}
