package koreanmaster.user.teacher.dao;

import koreanmaster.common.ExecuteSql;
import koreanmaster.user.teacher.dto.TeacherDTO;

import java.sql.SQLException;

public class TeacherDAO {
    private final ExecuteSql executeSql;
    public TeacherDAO () throws SQLException {
        executeSql = new ExecuteSql();
    }
    public void addTeacher(TeacherDTO teacher) throws SQLException {
        String sql = "INSERT INTO Student VALUES (\"" + teacher.getEmail() +"\", \""
                + teacher.getName() + "\", \"" + teacher.getBirth() + "\", "
                + teacher.isQualified() +", \"" + teacher.getPhone() + "\");";

        executeSql.noResult(sql);
    }
}
