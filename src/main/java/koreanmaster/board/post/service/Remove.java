package koreanmaster.board.post.service;

import koreanmaster.board.post.dao.Delete;
import koreanmaster.board.post.dao.Select;

import java.sql.SQLException;

public class Remove {
    private final int postId;

    public Remove(int postId) throws SQLException {
        this.postId = postId;
    }

    public boolean run() throws SQLException {
        Select selectTool = new Select();
        if (selectTool.notNullReplyId(this.postId)) return false;

        try {
            Delete deleteTool = new Delete();
            deleteTool.remove(this.postId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
