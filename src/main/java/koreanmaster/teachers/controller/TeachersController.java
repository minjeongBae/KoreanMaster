package koreanmaster.teachers.controller;

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
    public String counsel(HttpSession session, Model model){
        if(session.getAttribute("userEmail")==null) {
            model.addAttribute("message", "로그인이 필요합니다.");
            return "redirect:/teachers";
        }
        return "counsel";
    }

    @GetMapping("/subscribe")
    public String subscribe(HttpSession session, Model model){
        if(session.getAttribute("userEmail")==null) {
            model.addAttribute("message", "로그인이 필요합니다.");
            return "redirect:/teachers";
        }
        return "subscribe";
    }

    @PostMapping("/success_subscribe")
    public String successSubscribe(HttpServletRequest request){
        int frequency = request.getIntHeader("frequency");
        System.out.println(frequency);
        return "success-subscribe";
    }
}
