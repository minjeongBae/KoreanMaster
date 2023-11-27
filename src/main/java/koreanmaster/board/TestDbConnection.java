package koreanmaster.board;

import java.sql.*;

public class TestDbConnection {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt;
        ResultSet rs;

        String jdbc = "jdbc:mysql://localhost:3306/koreanmasterdb"
                +"?useSSL=false" + "&serverTimezone=Asia/Seoul";// jdbc URL
        String user_name = "root";
        String pw = "qoalswjd620!";

        String sql;

        // 접속
        try {
            con = DriverManager.getConnection(jdbc,user_name, pw);
            System.out.println("연결 성공");

            sql = "SELECT * FROM Board";

            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
                System.out.println("=============================");
            }
        } catch(SQLException e) {
            System.err.println("오류 : " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (con != null) try{
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
