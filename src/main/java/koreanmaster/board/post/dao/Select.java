package koreanmaster.board.post.dao;

import koreanmaster.board.CommonDao;
import koreanmaster.board.post.PostDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select extends CommonDao {
    public Select() throws SQLException {
    }

    public List<PostDto> getByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Post WHERE writer = \"" + email + "\"";
        ResultSet rs = executeSql.getResult(sql);

        List<PostDto> posts = new ArrayList<>();
        while (rs.next()) {
            String replyId = rs.getString(6);
            if (replyId == null) replyId = "0";
            PostDto post = new PostDto(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    Integer.parseInt(replyId)
            );
            posts.add(post);
        }
        return posts;
    }

    public PostDto get(int postId) throws SQLException {
        String sql = "SELECT * FROM Post WHERE post_id = \"" + postId + "\"";
        ResultSet rs = executeSql.getResult(sql);

        PostDto post = null;
        while (rs.next()) {
            String replyId = rs.getString(6);
            if (replyId == null) replyId = "0";
            post = new PostDto(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    Integer.parseInt(replyId)
            );
        }
        return post;
    }

    public List<PostDto> getAll() throws SQLException {
        String sql = "SELECT * FROM Post;";
        ResultSet rs = executeSql.getResult(sql);
        List<PostDto> posts = new ArrayList<>();

        while (rs.next()) {
            String replyId = rs.getString(6);
            if (replyId == null) replyId = "0";
            PostDto post = new PostDto(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    Integer.parseInt(replyId)
            );
            posts.add(post);
        }
        return posts;
    }

    public boolean notNullReplyId(int postId) throws SQLException {
        String sql = "SELECT reply_id FROM Post WHERE post_id= " + postId + ";";
        ResultSet rs = executeSql.getResult(sql);

        while (rs.next()) {
            if (rs.getInt(1) > 0) return true;
        }
        return false;
    }

    public int getReplyId(int postId) throws SQLException {
        String sql = "SELECT reply_id FROM Post WHERE post_id= " + postId + ";";
        ResultSet rs = executeSql.getResult(sql);
        rs.next();
        return rs.getInt(1);
    }

    public int getTheLast() throws SQLException {
        String sql = "SELECT MAX(post_id) FROM Post;";
        ResultSet rs = executeSql.getResult(sql);
        int postId = -1;

        while (rs.next()) {
            postId = Integer.parseInt(rs.getString(1));
        }
        return postId;
    }
}
