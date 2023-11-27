package koreanmaster.board.dao;

import koreanmaster.CommonConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {
    private final CommonConnection connection;

    public BoardDAO(){
        connection = new CommonConnection();
    }

    public void showMyBoard(String email) throws SQLException {
        String sql = "SELECT * FROM Board WHERE writer = \""+email+"\"";
        System.out.println(sql);
        ResultSet rs = connection.executeSQL(sql);
        while(rs.next()){
            System.out.println(rs.getString("content"));
        }
    }
}
