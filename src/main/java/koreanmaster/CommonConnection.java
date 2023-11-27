package koreanmaster;

import java.sql.*;

public class CommonConnection {
    private final static String jdbc = "jdbc:mysql://localhost:3306/koreanmasterdb"
            +"?useSSL=false" + "&serverTimezone=Asia/Seoul";// jdbc URL
    private final static String user_name = "root";
    private final static String pw = "qoalswjd620!";

    private Connection con;
    private Statement stmt;

    public CommonConnection(){
        try {
            con = DriverManager.getConnection(jdbc,user_name, pw);
            System.out.println("연결 성공");
            stmt = con.createStatement();
        } catch(SQLException e) {
            System.err.println("오류 : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ResultSet executeSQL(String sql){
        try{
            return stmt.executeQuery(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean close(){
        if (con != null) try{
            con.close();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
