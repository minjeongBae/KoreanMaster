package koreanmaster.teachers.applicationform.dao;

import koreanmaster.common.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends Dao {
    public Select() throws SQLException {
    }

    public int getByCode(int code) throws SQLException {
        String sql = "SELECT * FROM Application_Form WHERE form_code = "
                + code + ";";
        ResultSet rs = executeSql.getResult(sql);
        int formCode = -1;

        while (rs.next()) {
            formCode = Integer.parseInt(rs.getString(1));
        }
        return formCode;
    }
}
