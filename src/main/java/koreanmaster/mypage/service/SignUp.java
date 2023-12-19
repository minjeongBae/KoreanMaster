package koreanmaster.mypage.service;

import koreanmaster.home.user.dao.Insert;
import koreanmaster.home.user.dao.Select;
import koreanmaster.home.user.dto.UserDTO;
import koreanmaster.mypage.student.dao.StudentDAO;
import koreanmaster.mypage.student.dto.StudentDTO;
import koreanmaster.teachers.teacher.dao.TeacherDAO;
import koreanmaster.teachers.teacher.dto.TeacherDTO;

import java.sql.SQLException;

public class SignUp {
    private UserDTO user;

    public void setUser(UserDTO user) {
        this.user = user;
    }
    public boolean checkPosition(){
        return user.isStudent();
    }

    public boolean ableEmail(String email) throws SQLException {
        return new Select().findByEmail(email);
    }


    public boolean studentUser(String name, String birth, int level, String phone) {
        try{
            StudentDTO student = new StudentDTO(user.getEmail(), user.getPassword(), name, birth, level, phone);
            StudentDAO dao = new StudentDAO();

            new Insert().addUser(user);
            dao.addStudent(student);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean teacherUser(String name, String birth, int english, boolean qualified,
                               boolean korean, int howLong, String phone){
        try{
            TeacherDTO teacher = new TeacherDTO(user.getEmail(), user.getPassword(),
                    name, birth, english, qualified,
                    korean, howLong, phone, 0);
            TeacherDAO dao = new TeacherDAO();

            new Insert().addUser(user);
            dao.addTeacher(teacher);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
