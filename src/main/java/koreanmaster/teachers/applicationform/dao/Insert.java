package koreanmaster.teachers.applicationform.dao;

import koreanmaster.common.Dao;
import koreanmaster.teachers.applicationform.ApplicationFormDTO;

import java.sql.SQLException;

public class Insert extends Dao {
    public Insert() throws SQLException {
    }

    public void apply(ApplicationFormDTO form){
        String sql = "INSERT INTO Application VALUES (NULL, \""+
                form.getTeacherEmail() + "\", \"" +
                form.getStudentEmail() +"\", "+ form.getState() +");";
        executeSql.noResult(sql);
    }

    public void makeApplication(int formCode, ApplicationFormDTO form){
        String sql = "INSERT INTO Application_Form VALUES (" + formCode
                + ", " + form.getFrequency() + ", " + form.getTime() +", "
                + form.getLevel() + ", " + form.getState() + ", "
                + form.getCounselTime() + ", \"" + form.getAddition() + "\");";

        System.out.println(sql);
        executeSql.noResult(sql);
    }
}
