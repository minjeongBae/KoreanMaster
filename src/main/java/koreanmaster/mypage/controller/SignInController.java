package koreanmaster.mypage.controller;

import koreanmaster.mypage.service.SignIn;
import koreanmaster.home.user.dao.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class SignInController {
    @GetMapping("/sign_in")
    public String signIn(HttpServletRequest request) {
        HttpSession s = request.getSession(false);
        s.invalidate();
        return "sign-in";
    }

    @PostMapping("/session")
    public String checkSession(HttpServletRequest rq, HttpSession session, Model model) throws SQLException {
        SignIn signin = new SignIn();
        boolean isSuccess = signin.isSuccess(rq.getParameter("userEmail"),
                rq.getParameter("userPW"));
        if(isSuccess) {
            String userEmail = rq.getParameter("userEmail");
            session.setAttribute("userEmail", userEmail);
            model.addAttribute("email", userEmail);
            if(new UserDAO().isStudent(userEmail)) {
                model.addAttribute("isStudent", true);
                return "my-page";
            }
            model.addAttribute("isStudent",false);
            return "my-page";
        }
        model.addAttribute("alertMessage","사용자 이메일 또는 비밀번호가 옳지 않습니다.");
        return "sign-in";

    }
}
