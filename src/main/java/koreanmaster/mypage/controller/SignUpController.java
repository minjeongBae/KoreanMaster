package koreanmaster.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignUpController {
    @PostMapping("/sign_up")
    public String signUp(HttpServletRequest rq) {
        return "sign-up";
    }

    @PostMapping("/sign_up/step2")
    public String signUpNextStep(HttpServletRequest rq){
        String position = rq.getParameter("position");
        if(position==null) return "sign-up";
        if(position.equals("student")){
            return "sign-up-student";
        }
        return "sign-up-teacher";
    }

    @PostMapping("/sign_up/success_membership")
    public String membership() {
        return "success-membership";
    }

}
