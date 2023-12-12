package koreanmaster.mypage.service;

import koreanmaster.user.dao.UserDAO;
import koreanmaster.user.dto.UserDTO;
import koreanmaster.user.student.dao.StudentDAO;
import koreanmaster.user.student.dto.StudentDTO;
import koreanmaster.user.teacher.dao.TeacherDAO;
import koreanmaster.user.teacher.dto.TeacherDTO;

import java.sql.SQLException;

public class SignUp {

    private UserDTO user;
    private UserDAO userDAO;

    public SignUp() throws SQLException {
        userDAO = new UserDAO();
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
    public boolean checkPosition(){
        return user.isStudent();
    }

    public boolean ableEmail(String email) throws SQLException {
        UserDAO dao = new UserDAO();
        return !dao.findByEmail(email);
    }


    public boolean studentUser(String name, String birth, int level, String phone) {
        try{
            StudentDTO student = new StudentDTO(user.getEmail(), user.getPassword(), name, birth, level, phone);
            StudentDAO dao = new StudentDAO();

            userDAO.addUser(this.user);
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

            userDAO.addUser(this.user);
            dao.addTeacher(teacher);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
