package koreanmaster.teachers.controller;

import koreanmaster.teachers.teacher.dao.IntroductionDAO;
import koreanmaster.teachers.teacher.dto.IntroductionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class TeachersController {
    @GetMapping("/teacher_page")
    public String teacherPage(HttpServletRequest request, Model model) throws SQLException {
        IntroductionDAO introductionDAO = new IntroductionDAO();
        System.out.println(Integer.parseInt(request.getParameter("introduction-id")));
        IntroductionDTO introduction = introductionDAO.getById(Integer.parseInt(request.getParameter("introduction-id")));
        model.addAttribute("introduction", introduction);
        return "teacher-page";
    }

    @GetMapping("/counsel")
    public String counsel(){
        return "counsel";
    }

    @GetMapping("/subscribe")
    public String subscribe(){
        return "subscribe";
    }
}
