package koreanmaster.mypage.student.dao;

import koreanmaster.common.Dao;

import java.sql.SQLException;

public class Update extends Dao {
    private final String email;

    public Update(String email) throws SQLException {
        this.email = email;
    }

    public void changeBirth(String newDate) {
        String sql = "UPDATE Student SET birth = \""
                + newDate + "\" WHERE email = \""
                + email + "\";";
        executeSql.noResult(sql);
    }

    public void changeName(String newName) {
        String sql = "UPDATE Student SET name = "
                + newName + " WHERE email = \""
                + email + "\";";
        executeSql.noResult(sql);
    }

    public void changePhone(String newPhone) {
        String sql = "UPDATE Student SET phone = "
                + newPhone + " WHERE email = \""
                + email + "\";";
        executeSql.noResult(sql);
    }

    public void changeEngLevel(String newEngLevel) {
        String sql = "UPDATE Student SET eng_level = "
                + newEngLevel + " WHERE email = \""
                + email + "\";";
        executeSql.noResult(sql);
    }
}
