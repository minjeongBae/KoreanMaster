package koreanmaster.teachers.applicationform.dao;

import koreanmaster.common.Dao;
import koreanmaster.teachers.applicationform.ApplicationFormDTO;

import java.sql.SQLException;

public class Insert extends Dao {
    public Insert() throws SQLException {
    }

    public void apply(ApplicationFormDTO form){
        String sql = "";
        executeSql.noResult(sql);
    }
}
