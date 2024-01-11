package koreanmaster.teachers.service;

import koreanmaster.teachers.teacher.SimpleTeacherDTO;
import koreanmaster.teachers.teacher.service.CheckTeacher;

import java.sql.SQLException;
import java.util.List;

public class ManageQualification {
    // 선생님 리스트업 -> db 에서 자격 true
    // introduction 추가
    private final CheckTeacher checkTeacher;
    public ManageQualification(CheckTeacher checkTeacher) {
        this.checkTeacher = checkTeacher;
    }
    public List<SimpleTeacherDTO> showTeachers(){
        return checkTeacher.allTeachers();
    }
}
