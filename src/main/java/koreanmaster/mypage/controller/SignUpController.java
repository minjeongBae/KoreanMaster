package koreanmaster.mypage.controller;

import koreanmaster.mypage.service.SignUp;
import koreanmaster.user.dao.UserDAO;
import koreanmaster.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class SignUpController {
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
            if(able) return "sign-up-student";
        }

        user = new UserDTO(rq.getParameter("email"),
                rq.getParameter("password"), false);
        boolean able = new SignUp().ableEmail(user.getEmail());
        if(able) return "sign-up-teacher";

        System.out.println("dup_email 에러에러");
        model.addAttribute("dup_email","이용이 불가능한 이메일입니다.");
        System.out.println("==================================================");
        return "sign-up";
    }

    @PostMapping("/sign_up/success_membership")
    public String membership() {
        return "success-membership";
    }

}
