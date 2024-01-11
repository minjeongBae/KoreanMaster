package koreanmaster.teachers.teacher.dao;

import koreanmaster.common.ExecuteSql;
import koreanmaster.teachers.teacher.SimpleTeacherDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    private final ExecuteSql executeSql;

    public TeacherDAO() throws SQLException {
        executeSql = new ExecuteSql();
    }
    // 비밀번호 생일 이름 전화번호
    // 영어소통능력수준 한국거주기간 자기소개

    public String getEmailByIntroductionId(int introductionId) throws SQLException {
        String sql = "SELECT email FROM Teacher WHERE introduction_id=\"" + introductionId + "\"";
        ResultSet rs = executeSql.getResult(sql);
        if(rs==null) return null;

        String result = "";
        while (rs.next()) {
            result =  rs.getString(1);
        }

        return result;
    }

    public void changeBirth(String email, String newDate) {
        String sql = "UPDATE Teacher SET birth = \""
                + newDate + "\" WHERE email = \""
                + email + "\";";
        executeSql.noResult(sql);
    }


    public List<SimpleTeacherDTO> allTeachers() throws SQLException {
        List<SimpleTeacherDTO> teachers = new ArrayList<>();
        String sql = "SELECT * FROM Teacher;";
        ResultSet rs = executeSql.getResult(sql);
        if(rs==null) return null;
        while (rs.next()) {
            teachers.add(new SimpleTeacherDTO(rs.getString(1),
                    rs.getBoolean(5),
                    rs.getInt(9)));
        }

        return teachers;
    }
}
