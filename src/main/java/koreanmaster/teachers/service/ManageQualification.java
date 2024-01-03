package koreanmaster.teachers.service;

import koreanmaster.teachers.teacher.SimpleTeacherDTO;
import koreanmaster.teachers.teacher.dao.TeacherDAO;

import java.sql.SQLException;
import java.util.List;

public class ManageQualification {
    // 선생님 리스트업 -> db 에서 자격 true
    // introduction 추가

    private final TeacherDAO tool;
    public ManageQualification() throws SQLException {
        tool = new TeacherDAO();
    }
    public List<SimpleTeacherDTO> showTeachers() throws SQLException {
        return tool.allTeachers();
    }
}
