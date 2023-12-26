package koreanmaster.teachers.applicationform.simpledao;

import koreanmaster.common.Dao;
import koreanmaster.teachers.applicationform.SimpleFormDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select extends Dao {

    public Select() throws SQLException {
    }

    public int getCode(String teacher, String student) throws SQLException {
        String sql = "SELECT form_code FROM Simple_Form WHERE teacher_email = \""
                + teacher + "\" AND student_email = \""
                + student + "\";";

        ResultSet rs = executeSql.getResult(sql);
        int formCode = -1;

        while (rs.next()) {
            formCode = Integer.parseInt(rs.getString(1));
        }
        return formCode;
    }

    public List<SimpleFormDTO> getAllOfTeacher(String teacher) throws SQLException {
        String sql = "SELECT * FROM Simple_Form WHERE teacher_email = \"" + teacher + "\"";
        ResultSet rs = executeSql.getResult(sql);
        List<SimpleFormDTO> applications = new ArrayList<>();

        while(rs.next()){
            applications.add(new SimpleFormDTO(teacher,
                    rs.getString("student_email"),
                    rs.getInt("state")));
        }
        return applications;
    }
    public List<SimpleFormDTO> getAllOfStudent(String student) throws SQLException {
        String sql = "SELECT * FROM Simple_Form WHERE student_email = \"" + student + "\"";
        ResultSet rs = executeSql.getResult(sql);
        List<SimpleFormDTO> applications = new ArrayList<>();

        while(rs.next()){
            applications.add(new SimpleFormDTO(rs.getString("teacher_email"),
                    rs.getString("student_email"),
                    rs.getInt("state")));
        }
        return applications;
    }

}
