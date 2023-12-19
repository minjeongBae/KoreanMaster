package koreanmaster.home.user.dao;

import koreanmaster.common.Dao;
import koreanmaster.home.user.dto.UserDTO;

import java.sql.SQLException;

public class Insert extends Dao {
    public Insert() throws SQLException {}

    public void addUser(UserDTO user) {
        String sql = "INSERT INTO User VALUES (\"" + user.getEmail() + "\", \""
                + user.getPassword() + "\", " + user.isStudent() + ");";
        executeSql.noResult(sql);
    }
}
