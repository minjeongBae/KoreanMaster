package koreanmaster.mypage.controller;

import koreanmaster.board.post.PostDTO;
import koreanmaster.board.post.service.Show;
import koreanmaster.home.user.dao.Select;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Controller
public class MyPageController {
    @GetMapping("/revise_user_info")
    public String reviseUserInfo(HttpSession sesssion, Model model) throws SQLException {
        String nowUser = (String) sesssion.getAttribute("userEmail");
        model.addAttribute("isStudent", new Select().isStudent(nowUser));

        return "revise-user-info";
    }

    @GetMapping("/my_posts")
    public String showMyPosts(HttpSession session, Model model) throws SQLException {
        Show show = new Show();
        String userEmail = (String) session.getAttribute("userEmail");
        List<PostDTO> myPosts = show.getByEmail(userEmail);
        model.addAttribute("myPosts", myPosts);
        model.addAttribute("email", userEmail);

        Select selectTool = new Select();
        if(selectTool.isStudent(userEmail)) {
            model.addAttribute("isStudent", true);
            return "my-page";
        }
        model.addAttribute("isStudent",false);

        return "my-page";
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
