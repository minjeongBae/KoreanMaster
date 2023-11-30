package koreanmaster.board.domain;

import koreanmaster.board.dao.PostDAO;
import koreanmaster.board.dto.PostDTO;

import java.sql.SQLException;

public class Post {
    private final PostDAO postDAO;
    private PostDTO post;

    public Post() throws SQLException {
        this.postDAO = new PostDAO();
    }
    public boolean registerPost(int boardId, String title, String writer,
                                String registrationDate,
                                String content, int replyId) throws SQLException {
        if(this.post!=null) return false;
        this.post = new PostDTO(boardId, title, writer,
                registrationDate, content, replyId);

        postDAO.upload(this.post);
        return true;
    }

    public boolean revisePost(String content) throws SQLException {
        if(this.post==null) return false;

        post.setContent(content);
        postDAO.revise(post.getPostId(), post.getContent());
        return true;
    }
}
