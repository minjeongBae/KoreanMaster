package koreanmaster.user.teacher.dao;

import koreanmaster.common.ExecuteSql;
import koreanmaster.user.teacher.dto.TeacherDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO {
    private final ExecuteSql executeSql;

    public TeacherDAO() throws SQLException {
        executeSql = new ExecuteSql();
    }

    public void addTeacher(TeacherDTO teacher) {
        String sql = "INSERT INTO Teacher VALUES (\"" + teacher.getEmail() + "\", \""
                + teacher.getName() + "\", \"" + teacher.getBirth() + "\", \"" + teacher.getEnglish() + "\", "
                + teacher.isQualified() + ", " + teacher.isKorean() + ", \"" + teacher.getHowLong() + "\", \""
                + teacher.getPhone() + "\");";
        executeSql.noResult(sql);
    }

    public int hasIntroduction(String email) throws SQLException {
        String sql = "SELECT introduction_id FROM Teacher WHERE email=\"" + email + "\"";
        ResultSet rs = executeSql.getResult(sql);

        if(rs==null) return 0;

        int introduction_id = 0;
        while (rs.next()) {
            introduction_id = rs.getInt(1);
        }

        return Math.max(introduction_id, 0);
    }
}
