package koreanmaster.board.dao;

import koreanmaster.ExecuteSql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDAO {
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final ExecuteSql executeSql;
    public BoardDAO() throws SQLException {
        executeSql = new ExecuteSql();
    }
    public void showByEmail(String myEmail) throws SQLException {
        String sql = "SELECT * FROM Board WHERE writer = \""+myEmail+"\"";
        ResultSet rs = executeSql.getResult(sql);
        while(rs.next()){
            System.out.println(rs.getString("content"));
        }
    }

    public void upload(String title, String email, String content) throws SQLException {
        String date = dateFormat.format(new Date());
        String sql = "INSERT INTO Board VALUES (NULL, \""
                + title + "\", \"" + email + "\", \""
                + date + "\", \"" + content + "\",NULL);";
        executeSql.noResult(sql);
    }

    public void revise(int boardId, String content) throws SQLException {
        String date = dateFormat.format(new Date());
        String sql = "UPDATE Board SET content = \"" + content
                + "\", registration_date = \"" + date +
                "\" WHERE board_id = " + boardId +";";
        System.out.println(sql);
        executeSql.noResult(sql);
    }
}
