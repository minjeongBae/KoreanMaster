package koreanmaster.user.dao;

import koreanmaster.common.ExecuteSql;
import koreanmaster.user.dto.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final ExecuteSql executeSql;
    public UserDAO() throws SQLException {
        executeSql = new ExecuteSql();
    }
    public UserDTO checkCorrect(String email, String password) throws SQLException {
        String sql = "SELECT * FROM User WHERE email = \""+email+"\" AND password = \"" + password + "\";";
        ResultSet rs = executeSql.getResult(sql);

        while(rs.next()){
            return new UserDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getBoolean(3)
            );
        }
        return null;
    }

    public void changePW(String email, String oldPW, String newPW) throws SQLException {
        String sql = "UPDATE User SET password = "
                + newPW + " WHERE email = \""
                + email + "\" AND password = \";"
                + oldPW + "\"";
        executeSql.noResult(sql);
    }

    public void addUser(UserDTO user) throws SQLException {
        String sql = "INSERT INTO User VALUES (\"" + user.getEmail() + "\", \"" + user.getPassword() + "\", " + user.isStudent() + ");";
        executeSql.noResult(sql);
    }

    public boolean findByEmail(String email) throws SQLException {
        String sql = "SELECT email FROM User WHERE email=\"" + email + "\";";
        ResultSet rs = executeSql.getResult(sql);

        while(rs.next()){
            System.out.println(rs.getString(1));
            if(rs.getString(1).equals(email)) return true;
        }
        return false;
    }

}
