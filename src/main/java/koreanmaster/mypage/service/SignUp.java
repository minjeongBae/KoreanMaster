package koreanmaster.mypage.service;

import koreanmaster.user.dao.UserDAO;
import koreanmaster.user.dto.UserDTO;
import koreanmaster.user.student.dao.StudentDAO;
import koreanmaster.user.student.dto.StudentDTO;
import koreanmaster.user.teacher.dao.TeacherDAO;
import koreanmaster.user.teacher.dto.TeacherDTO;

import java.sql.SQLException;

public class SignUp {
    public boolean ableEmail(String email) throws SQLException {
        UserDAO dao = new UserDAO();
        return !dao.findByEmail(email);
    }
    public boolean studentUser(String email, String pw, String name,
                               String birth, int level, String phone) {
        try{
            StudentDTO student = new StudentDTO(email, pw, name, birth, level, phone);
            StudentDAO dao = new StudentDAO();
            dao.addStudent(student);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean teacherUser(String email, String password, String name,
                               String birth, boolean qualified, String phone){
        try{
            TeacherDTO teacher = new TeacherDTO(email, password, name, birth, qualified, phone);
            TeacherDAO dao = new TeacherDAO();
            dao.addTeacher(teacher);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}