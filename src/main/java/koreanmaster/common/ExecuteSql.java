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
        try {
            // 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결 설정
            con = DriverManager.getConnection(jdbc, user_name, pw);
            stmt = con.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        }
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

    public void noResult(String sql){
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
