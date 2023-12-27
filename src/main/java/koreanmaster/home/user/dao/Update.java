package koreanmaster.home.user.dao;

import koreanmaster.common.Dao;

import java.sql.SQLException;

public class Update extends Dao {
    public Update() throws SQLException {}

    public void changePw(String email, String oldPW, String newPW) {
        String sql = "UPDATE User SET password = "
                + newPW + " WHERE email = \""
                + email + "\" AND password = \""
                + oldPW + "\";";
        executeSql.noResult(sql);
    }
}
