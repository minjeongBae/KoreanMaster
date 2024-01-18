package koreanmaster.teachers;

import koreanmaster.teachers.applicationform.ApplicationFormDTO;
import koreanmaster.teachers.applicationform.SimpleFormDTO;
import koreanmaster.teachers.applicationform.service.AddForm;
import koreanmaster.teachers.teacher.introduction.IntroductionDTO;
import koreanmaster.teachers.teacher.introduction.service.GetIntroduction;
import koreanmaster.teachers.teacher.service.CheckTeacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class TeachersController {
    private final CheckTeacher checkTeacher;
    private final AddForm addForm;
    private final GetIntroduction getIntroduction;

    public TeachersController(CheckTeacher checkTeacher, AddForm addForm,
                              GetIntroduction getIntroduction) {
        this.checkTeacher = checkTeacher;
        this.addForm = addForm;
        this.getIntroduction = getIntroduction;
    }

    @GetMapping("/teacher_page")
    public String teacherPage(HttpServletRequest request, Model model) throws SQLException {
        IntroductionDTO introduction = getIntroduction.getById(
                Integer.parseInt(request.getParameter("introduction-id")));
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

    @GetMapping("/manage_teachers")
    public String manageTeachers(HttpSession session, Model model) {
        // 현재 session 의 사용자가 관리자일 경우
        model.addAttribute("teachers",checkTeacher.allTeachers());
        return "manage-qualification";
        // 아니면 로그인 화면으로
    }

    @PostMapping("/success_subscribe")
    public String successSubscribe(HttpServletRequest request, HttpSession session) {
        String teacher = checkTeacher.getEmailByIntroId(Integer.parseInt(request.getParameter("introductionId")));

        int frequency = Integer.parseInt(request.getParameter("frequency"));
        int time = Integer.parseInt(request.getParameter("time"));
        String root = request.getParameter("root");
        int level = Integer.parseInt(request.getParameter("level"));
        int state = 0;
        int counselTime = Integer.parseInt(request.getParameter("counselTime"));
        String addition = request.getParameter("addition");
        String student = (String) session.getAttribute("userEmail");

        ApplicationFormDTO form = new ApplicationFormDTO(
                                    teacher,student,frequency,
                                    time,root,level,
                                    state,counselTime,addition);

        SimpleFormDTO simpleForm = new SimpleFormDTO(0, teacher, student,state);
        addForm.run(simpleForm, form);
        return "success-subscribe";
    }
}
