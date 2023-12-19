package koreanmaster.mypage.student.dao;

import koreanmaster.common.Dao;
import koreanmaster.mypage.student.dto.StudentDTO;

import java.sql.SQLException;

public class Insert extends Dao {
    public Insert() throws SQLException {}

    public void addStudent(StudentDTO student) {
        String sql = "INSERT INTO Student VALUES (\"" + student.getEmail() + "\", \""
                + student.getName() + "\", \"" + student.getBirth() + "\", "
                + student.getEnglish() + ", \"" + student.getPhone() + "\");";
        executeSql.noResult(sql);
    }
}
