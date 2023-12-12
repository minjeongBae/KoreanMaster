package koreanmaster.board.dao;

import koreanmaster.common.ExecuteSql;
import koreanmaster.board.dto.PostDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private final ExecuteSql executeSql;

    public PostDAO() throws SQLException {
        executeSql = new ExecuteSql();
    }

    public List<PostDTO> getByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Post WHERE writer = \"" + email + "\"";
        ResultSet rs = executeSql.getResult(sql);

        List<PostDTO> posts = new ArrayList<>();
        while (rs.next()) {
            String replyId = rs.getString(6);
            if (replyId == null) replyId = "0";
            PostDTO post = new PostDTO(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    Integer.parseInt(replyId)
            );
            posts.add(post);
        }

        return posts;
    }

    public PostDTO getByPostId(int postId) throws SQLException {
        String sql = "SELECT * FROM Post WHERE post_id = \"" + postId + "\"";
        ResultSet rs = executeSql.getResult(sql);

        PostDTO post = null;
        while (rs.next()) {
            String replyId = rs.getString(6);
            if (replyId == null) replyId = "0";
            post = new PostDTO(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    Integer.parseInt(replyId)
            );
        }

        return post;
    }

    public List<PostDTO> allPosts() throws SQLException {
        String sql = "SELECT * FROM Post;";
        ResultSet rs = executeSql.getResult(sql);
        List<PostDTO> posts = new ArrayList<>();

        while (rs.next()) {
            String replyId = rs.getString(6);
            if (replyId == null) replyId = "0";
            PostDTO post = new PostDTO(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    Integer.parseInt(replyId)
            );
            posts.add(post);
        }

        return posts;
    }

    public void upload(PostDTO post) throws SQLException {
        String sql = "INSERT INTO Post VALUES (NULL, \""
                + post.getTitle() + "\", \"" + post.getWriter() + "\", \""
                + post.getRegistrationDate() + "\", \"" + post.getContent() + "\",NULL);";
        executeSql.noResult(sql);
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

    public void removeReply(int postId) {
        String sql = "UPDATE Post SET reply_id = NULL "
                + "WHERE post_id = " + postId + ";";
        executeSql.noResult(sql);
    }

    public int getReplyId(int postId) throws SQLException {
        String sql = "SELECT reply_id FROM Post WHERE post_id = " + postId + ";";
        ResultSet rs = executeSql.getResult(sql);
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public void remove(int postId) throws SQLException {
        String sql = "DELETE FROM Post WHERE post_id = " + postId;
        executeSql.noResult(sql);
    }
}
