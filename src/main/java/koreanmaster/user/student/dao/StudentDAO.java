package koreanmaster.user.student.dao;

import koreanmaster.common.ExecuteSql;
import koreanmaster.user.student.dto.StudentDTO;

import java.sql.SQLException;

public class StudentDAO {
    private final ExecuteSql executeSql;
    public StudentDAO () throws SQLException {
        executeSql = new ExecuteSql();
    }
    public void addStudent(StudentDTO student) throws SQLException {
        String sql = "INSERT INTO Student VALUES (\"" + student.getEmail() +"\", \""
                + student.getName() + "\", \"" + student.getBirth() + "\", "
                + student.getEnglish() +", \"" + student.getPhone() + "\");";
        executeSql.noResult(sql);
    }
}
