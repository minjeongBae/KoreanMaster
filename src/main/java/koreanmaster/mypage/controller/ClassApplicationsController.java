package koreanmaster.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ClassApplicationsController {

    @Autowired
    public ClassApplicationsController(){
    }
    @PostMapping("/show_detail_application")
    public String showDetailApplication(HttpServletRequest rq, Model model){
        System.out.println("code: "+rq.getParameter("formCode"));
        model.addAttribute("formCode", rq.getParameter("formCode"));
        return "show-detail-application";
    }
    @PostMapping("/show_detail_class")
    public String showDetailClass(HttpServletRequest rq, Model model){
        System.out.println("code: "+rq.getParameter("formCode"));
        model.addAttribute("formCode", rq.getParameter("formCode"));
        return "show-detail-class";
    }
}
