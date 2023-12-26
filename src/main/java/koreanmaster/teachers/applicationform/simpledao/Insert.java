package koreanmaster.teachers.applicationform.simpledao;

import koreanmaster.common.Dao;
import koreanmaster.teachers.applicationform.SimpleFormDTO;

import java.sql.SQLException;

public class Insert extends Dao {
    public Insert() throws SQLException {
    }

    public void add(SimpleFormDTO form){
        String sql = "INSERT INTO Simple_Form VALUES (NULL, \""+
                form.getTeacherEmail() + "\", \"" +
                form.getStudentEmail() +"\", "+ form.getState() +");";
        executeSql.noResult(sql);
    }
}
