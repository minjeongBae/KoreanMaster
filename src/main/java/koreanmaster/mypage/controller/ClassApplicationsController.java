package koreanmaster.mypage.controller;

import koreanmaster.teachers.applicationform.ApplicationFormDTO;
import koreanmaster.teachers.applicationform.service.RemoveForm;
import koreanmaster.teachers.applicationform.service.ShowForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ClassApplicationsController {
    private final ShowForm showForm;
    private final RemoveForm removeForm;

    @Autowired
    public ClassApplicationsController(ShowForm showForm, RemoveForm removeForm){
        this.showForm = showForm;
        this.removeForm = removeForm;
    }
    @PostMapping("/show_detail_application")
    public String showDetailApplication(HttpServletRequest rq, Model model){
        int formCode = Integer.parseInt(rq.getParameter("formCode"));
        model.addAttribute("formCode", formCode);
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

    @PostMapping("/remove_form")
    public String removeForm(HttpServletRequest rq, Model model, HttpSession session){
        int formCode = Integer.parseInt(rq.getParameter("formCode"));

        removeForm.run(formCode);

        String email = (String) session.getAttribute("userEmail");
        model.addAttribute("classes", showForm.getAllOfStudent(email));
        return "show-classes";
    }
}
