package koreanmaster.teachers.controller;

import koreanmaster.teachers.teacher.dao.TeacherDAO;
import koreanmaster.teachers.teacher.introduction.IntroductionDAO;
import koreanmaster.teachers.teacher.introduction.IntroductionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class TeachersController {
    @GetMapping("/teacher_page")
    public String teacherPage(HttpServletRequest request, Model model) throws SQLException {
        IntroductionDAO introductionDAO = new IntroductionDAO();
        IntroductionDTO introduction = introductionDAO.getById(Integer.parseInt(request.getParameter("introduction-id")));
        model.addAttribute("introduction", introduction);
        return "teacher-page";
    }

    @GetMapping("/counsel")
    public String counsel(HttpSession session, HttpServletRequest request, Model model){
        if(session.getAttribute("userEmail")==null) {
            model.addAttribute("message", "로그인이 필요합니다.");
            return "redirect:/teachers";
        }
        model.addAttribute("introductionId", request.getParameter("introductionId"));
        return "counsel";
    }

    @GetMapping("/subscribe")
    public String subscribe(HttpSession session, HttpServletRequest request, Model model){
        if(session.getAttribute("userEmail")==null) {
            model.addAttribute("message", "로그인이 필요합니다.");
            return "redirect:/teachers";
        }
        model.addAttribute("introductionId", request.getParameter("introductionId"));
        return "subscribe";
    }

    @PostMapping("/success_subscribe")
    public String successSubscribe(HttpServletRequest request, HttpSession session) throws SQLException {
        System.out.println("/success_subscribe: "+request.getParameter("introductionId"));
        TeacherDAO dao = new TeacherDAO();
        System.out.println(dao.getEmailByIntroductionId(Integer.parseInt(request.getParameter("introductionId"))));
        int frequency = Integer.parseInt(request.getParameter("frequency"));
        int time = Integer.parseInt(request.getParameter("time"));
        String root = request.getParameter("root");
        int level = Integer.parseInt(request.getParameter("level"));
        int state = 0;
        int counselTime = Integer.parseInt(request.getParameter("counselTime"));
        String addition = request.getParameter("addition");
        String student = (String) session.getAttribute("userEmail");

        return "success-subscribe";
    }
}
