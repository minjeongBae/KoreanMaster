package koreanmaster.board.service;

import koreanmaster.board.dao.PostDAO;
import koreanmaster.board.dto.PostDTO;

import java.sql.SQLException;

public class PostManage {
    private final static int NULL_REPLY = 0;
    private final PostDAO postDAO;
    private PostDTO post;

    public PostManage() throws SQLException {
        this.postDAO = new PostDAO();
    }

    public boolean registerPost(String title, String writer,
                                String registrationDate,
                                String content) throws SQLException {
        if (this.post != null) return false;
        this.post = new PostDTO(0, title, writer,
                registrationDate, content, NULL_REPLY);

        postDAO.upload(this.post);
        return true;
    }

    public boolean revisePost(String content) {
        if (this.post == null) return false;

        post.setContent(content);
        postDAO.revise(post.getPostId(), post.getContent());
        return true;
    }

    public boolean addReply(int replyId) {
        if (post.getReplyId() == NULL_REPLY) {
            post.setReplyId(replyId);
            postDAO.addReply(post.getPostId(), post.getReplyId());
            return true;
        }
        return false;
    }

    public boolean removeReply() {
        if (post.getReplyId() == NULL_REPLY) return false;
        postDAO.removeReply(post.getPostId());
        post.setReplyId(NULL_REPLY);
        return true;
    }

    public boolean remove() throws SQLException {
        if (post.getReplyId() == NULL_REPLY) {
            // post 객체가 존재하며 해당 게시글의 댓글이 없는 상태일 때 동작
            postDAO.remove(post.getPostId());
            post = null;
            return true;
        }
        return false;
    }
}
