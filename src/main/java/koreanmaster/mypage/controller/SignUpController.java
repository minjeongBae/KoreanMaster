package koreanmaster.mypage.controller;

import koreanmaster.mypage.service.SignUp;
import koreanmaster.home.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class SignUpController {
    private SignUp service = new SignUp();

    public SignUpController() throws SQLException {
    }

    @GetMapping("/sign_up")
    public String signUp() {
        return "sign-up";
    }

    @PostMapping("/sign_up/step2")
    public String signUpNextStep(HttpServletRequest rq, Model model) throws SQLException {
        String position = rq.getParameter("position");
        UserDTO user;
        if(position.equals("student")){
            user = new UserDTO(rq.getParameter("email"),
                    rq.getParameter("password"), true);
            boolean able = new SignUp().ableEmail(user.getEmail());
            System.out.println("학생으로 체크하고 user등록 가능한가: "+able);
            if(able) {
                service.setUser(user);
                return "sign-up-student";
            }
        }

        user = new UserDTO(rq.getParameter("email"),
                rq.getParameter("password"), false);
        boolean able = new SignUp().ableEmail(user.getEmail());
        if(able) {
            service.setUser(user);
            return "sign-up-teacher";
        }

        model.addAttribute("dup_email","이용이 불가능한 이메일입니다.");
        return "sign-up";
    }

    @PostMapping("/sign_up/success_membership")
    public String membership(HttpServletRequest rq) {
        if(service.checkPosition()) {
            //String name, String birth, int english, String phone
            service.studentUser(rq.getParameter("name"),
                    rq.getParameter("birth"),
                    Integer.parseInt(rq.getParameter("english")),
                    rq.getParameter("phone")
                    );
            return "success-membership";
        }

        boolean isKorean = Boolean.getBoolean(rq.getParameter("is_korean"));
        int howLong=5;
        if(!isKorean) howLong=Integer.parseInt(rq.getParameter("years"));
        service.teacherUser(rq.getParameter("name"),
                rq.getParameter("birth"),
                Integer.parseInt(rq.getParameter("english")), false,
                isKorean, howLong, rq.getParameter("phone")
                );

        return "success-membership";
    }


}
