package koreanmaster.board.dao;

import koreanmaster.ExecuteSql;
import koreanmaster.board.dto.PostDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDAO {
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final ExecuteSql executeSql;
    public PostDAO() throws SQLException {
        executeSql = new ExecuteSql();
    }
    public void getByEmail(String email) throws SQLException, ParseException {
        String sql = "SELECT * FROM Post WHERE writer = \""+email+"\"";
        ResultSet rs = executeSql.getResult(sql);
        List<PostDTO> allPost = new ArrayList<>();
        while(rs.next()){
            PostDTO post = new PostDTO(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3),
                    dateFormat.parse(rs.getString(4)),
                    rs.getString(5),
                    Integer.parseInt(rs.getString(6))
            );
            allPost.add(post);
            System.out.println(post.printInfo());
        }
    }

    public void upload(String title, String email, String content) throws SQLException {
        String date = dateFormat.format(new Date());
        String sql = "INSERT INTO Post VALUES (NULL, \""
                + title + "\", \"" + email + "\", \""
                + date + "\", \"" + content + "\",NULL);";
        executeSql.noResult(sql);
    }

    public void revise(int postId, String content) throws SQLException {
        String date = dateFormat.format(new Date());
        String sql = "UPDATE Post SET content = \"" + content
                + "\", registration_date = \"" + date +
                "\" WHERE post_id = " + postId +";";
        executeSql.noResult(sql);
    }
}
