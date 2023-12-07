package koreanmaster.notuser.controller;

import koreanmaster.user.service.SignIn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class NotUserController {
    @GetMapping("/sign_in")
    public String signIn(HttpServletRequest request) {
        HttpSession s = request.getSession(false);
        s.invalidate();
        return "sign-in";
    }

    @GetMapping("/sign_up")
    public String signUp() {
        return "sign-up";
    }

    @PostMapping("/sign_up/step2")
    public String signUpNextStep(HttpServletRequest rq){
        System.out.println(rq.getParameter("position"));
        if(rq.getParameter("position").equals("student")){
            return "sign-up-student";
        }
        return "sign-up-teacher";
    }

    @PostMapping("/session")
    public String checkSession(HttpServletRequest rq, HttpSession session, Model model) throws SQLException {
        SignIn signin = new SignIn();
        boolean isSuccess = signin.isSuccess(rq.getParameter("userEmail"),
                        rq.getParameter("userPW"));
        if(isSuccess) {
            session.setAttribute("userEmail", rq.getParameter("userEmail"));
            model.addAttribute("email", rq.getParameter("userEmail"));
            return "my-page";
        }
        return "sign-in";

    }

}
