package koreanmaster.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {
    @GetMapping("/revise_user_info")
    public String reviseUserInfo(Model model){

        //model.addAttribute("isStudent", true);
        //model.addAttribute("isStudent", true);

        return "revise-user-info";
    }

    @GetMapping("/show_classes")
    public String showClasses(Model model){

        return "show-classes";
    }
}
