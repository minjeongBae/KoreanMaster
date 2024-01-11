package koreanmaster.mypage.controller;

import koreanmaster.home.user.service.AddUser;
import koreanmaster.home.user.UserDTO;
import koreanmaster.home.user.service.CheckUser;
import koreanmaster.mypage.student.StudentDTO;
import koreanmaster.mypage.student.service.AddStudent;
import koreanmaster.teachers.teacher.TeacherDTO;
import koreanmaster.teachers.teacher.service.AddTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class SignUpController {
    private final AddUser addUser;
    private final AddStudent addStudent;
    private final AddTeacher addTeacher;
    private final CheckUser checkUser;
    private UserDTO user;
    @Autowired
    public SignUpController(AddUser addUser, AddTeacher addTeacher,
                            AddStudent addStudent, CheckUser checkUser){
        this.addUser = addUser;
        this.addStudent = addStudent;
        this.addTeacher = addTeacher;
        this.checkUser = checkUser;
    }
    @GetMapping("/sign_up")
    public String signUp() {
        return "sign-up";
    }

    @PostMapping("/sign_up/step2")
    public String signUpNextStep(HttpServletRequest rq, Model model) throws SQLException {
        String position = rq.getParameter("position");
        String tempEmail = rq.getParameter("email");

        boolean able = checkUser.isAbleEmail(tempEmail);
        if(!able) {
            model.addAttribute("dup_email","이용이 불가능한 이메일입니다.");
            return "sign-up";
        }

        if(position.equals("student")){
            user = new UserDTO(tempEmail, rq.getParameter("password"), true);
            return "sign-up-student";
        }

        user = new UserDTO(tempEmail, rq.getParameter("password"), false);
        return "sign-up-teacher";
    }

    @PostMapping("/sign_up/success_membership")
    public String membership(HttpServletRequest rq) {
        if(user.isStudent()) {
            StudentDTO student = new StudentDTO(user.getEmail(), user.getPassword(),
                    rq.getParameter("name"), rq.getParameter("birth"),
                    Integer.parseInt(rq.getParameter("english")),
                    rq.getParameter("phone"));

            addUser.run(user);
            addStudent.run(student);

            return "success-membership";
        }

        boolean isKorean = Boolean.getBoolean(rq.getParameter("is_korean"));
        int howLong=5;
        if(!isKorean) howLong=Integer.parseInt(rq.getParameter("years"));

        TeacherDTO teacher = new TeacherDTO(user.getEmail(), user.getPassword(),
                rq.getParameter("name"), rq.getParameter("birth"),
                Integer.parseInt(rq.getParameter("english")), false,
                isKorean, howLong, rq.getParameter("phone"), 0);

        addUser.run(user);
        addTeacher.run(teacher);

        return "success-membership";
    }
}
