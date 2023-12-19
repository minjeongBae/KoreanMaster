package koreanmaster.mypage.controller;

import koreanmaster.home.user.dao.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class MyPageController {
    @GetMapping("/revise_user_info")
    public String reviseUserInfo(HttpSession sesssion, Model model) throws SQLException {
        UserDAO userDAO = new UserDAO();
        String nowUser = (String) sesssion.getAttribute("userEmail");
        model.addAttribute("isStudent", userDAO.isStudent(nowUser));

        return "revise-user-info";
    }

    @GetMapping("/show_classes")
    public String showClasses(Model model){
        // student version
        return "show-classes";
    }

    @GetMapping("/show_application")
    public String showApplication(){
        // teacher version
        return "show-application";
    }
}
