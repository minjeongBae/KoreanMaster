package koreanmaster.home.user.dao;

import koreanmaster.common.Dao;
import koreanmaster.home.user.dto.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends Dao {
    public Select() throws SQLException {}
    public UserDTO checkUser(String email, String password) throws SQLException {
        String sql = "SELECT * FROM User WHERE email = \"" + email + "\" AND password = \"" + password + "\";";
        ResultSet rs = executeSql.getResult(sql);

        while (rs.next()) {
            return new UserDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getBoolean(3)
            );
        }
        return null;
    }

    public boolean findByEmail(String email) throws SQLException {
        String sql = "SELECT email FROM User WHERE email=\"" + email + "\";";
        ResultSet rs = executeSql.getResult(sql);

        while (rs.next()) {
            System.out.println(rs.getString(1));
            if (rs.getString(1).equals(email)) return true;
        }
        return false;
    }

    public boolean isManager(String email) throws SQLException {
        String sql = "SELECT email FROM Manager WHERE email=\"" + email + "\";";
        ResultSet rs = executeSql.getResult(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
            if (rs.getString(1).equals(email)) return true;
        }
        return false;
    }

    public boolean isStudent(String email) throws SQLException {
        String sql = "SELECT * FROM User WHERE email=\"" + email + "\";";
        ResultSet rs = executeSql.getResult(sql);
        while (rs.next()) {
            if (rs.getBoolean(3)) return true;
        }
        return false;
    }
}
