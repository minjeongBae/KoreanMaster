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

    public String getName(String email) throws SQLException {
        String sql = "SELECT name FROM Teacher WHERE email=\"" + email + "\"";
        ResultSet rs = executeSql.getResult(sql);
        if(rs==null) return "";

        String name = "";
        while (rs.next()) {
            name = rs.getString(1);
        }

        return name;
    }

    public TeacherDTO getByIntroductionId(int introductionId) throws SQLException {
        String sql = "SELECT * FROM Teacher WHERE introduction_id=\"" + introductionId + "\"";
        ResultSet rs = executeSql.getResult(sql);
        if(rs==null) return null;

        TeacherDTO result = null;
        while (rs.next()) {
            result = new TeacherDTO(
                    rs.getString(1),
                    "", rs.getString(2),
                    rs.getString(3), rs.getInt(4), rs.getBoolean(5),
                    rs.getBoolean(6), rs.getInt(7), rs.getString(8),
                    rs.getInt(9)
            );
        }

        return result;
    }
}
