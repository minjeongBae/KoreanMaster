package koreanmaster.board.post.service;

import koreanmaster.board.post.dao.Select;
import koreanmaster.board.post.dao.Update;

import java.sql.SQLException;

public class Revise {
    private final int postId;
    private final String newContent;

    public Revise(int postId, String newContent) {
        this.postId = postId;
        this.newContent = newContent;
    }

    public boolean run() throws SQLException {
        Select selectTool = new Select();
        if (selectTool.notNullReplyId(this.postId)) return false;

        try {
            Update updateTool = new Update();
            updateTool.revise(this.postId, this.newContent);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
