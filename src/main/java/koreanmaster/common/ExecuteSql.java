package koreanmaster.common;

import java.sql.*;

public class ExecuteSql {
    private final static String jdbc = "jdbc:mysql://localhost:3306/koreanmasterdb"
            +"?useSSL=false" + "&serverTimezone=Asia/Seoul";// jdbc URL
    private final static String user_name = "root";
    private final static String pw = "qoalswjd620!";

    private Connection con;
    private Statement stmt;

    public ExecuteSql() throws SQLException {
        con = DriverManager.getConnection(jdbc,user_name, pw);
        System.out.println("연결 성공");
        stmt = con.createStatement();
    }

    public ResultSet getResult(String sql){
        try{
            return stmt.executeQuery(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void noResult(String sql) throws SQLException {
        try{
            stmt.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        con.close();
    }
}
