package koreanmaster.mypage.controller;

import koreanmaster.teachers.applicationform.ApplicationFormDTO;
import koreanmaster.teachers.applicationform.service.ShowForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ClassApplicationsController {
    private final ShowForm showForm;

    @Autowired
    public ClassApplicationsController(ShowForm showForm){
        this.showForm = showForm;
    }
    @PostMapping("/show_detail_application")
    public String showDetailApplication(HttpServletRequest rq, Model model){
        int formCode = Integer.parseInt(rq.getParameter("formCode"));
        model.addAttribute("formCode", formCode);
        System.out.println("form Code in show detail application (): "+ formCode);
        model.addAttribute("form", showForm.getForm(formCode));
        return "show-detail-application";
    }
    @PostMapping("/show_detail_class")
    public String showDetailClass(HttpServletRequest rq, Model model){
        int formCode = Integer.parseInt(rq.getParameter("formCode"));
        model.addAttribute("formCode", formCode);
        model.addAttribute("form", showForm.getForm(formCode));
        return "show-detail-class";
    }
}
