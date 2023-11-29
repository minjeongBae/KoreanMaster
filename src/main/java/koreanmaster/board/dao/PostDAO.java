package koreanmaster.board.dao;

import koreanmaster.common.ExecuteSql;
import koreanmaster.board.dto.PostDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDAO {    private final ExecuteSql executeSql;
    public PostDAO() throws SQLException {
        executeSql = new ExecuteSql();
    }
    public List<PostDTO> getAllByEmail(String email) throws SQLException, ParseException {
        String sql = "SELECT * FROM Post WHERE writer = \""+email+"\"";
        ResultSet rs = executeSql.getResult(sql);

        List<PostDTO> allPost = new ArrayList<>();
        while(rs.next()){
            PostDTO post = new PostDTO(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    Integer.parseInt(rs.getString(6))
            );
            allPost.add(post);
        }

        return allPost;
    }

    public void upload(String title, String email, String date, String content) throws SQLException {
        String sql = "INSERT INTO Post VALUES (NULL, \""
                + title + "\", \"" + email + "\", \""
                + date + "\", \"" + content + "\",NULL);";
        executeSql.noResult(sql);
    }

    public void revise(int postId, String content, Date date) throws SQLException {
        String sql = "UPDATE Post SET content = \"" + content
                + "\", registration_date = \"" + date +
                "\" WHERE post_id = " + postId +";";
        executeSql.noResult(sql);
    }

    public void addReply(int postId, int replyId) throws SQLException {
        String sql = "UPDATE Post SET reply_id = "
                + replyId + " WHERE post_id = "
                + postId + ";";
        executeSql.noResult(sql);
    }
}
