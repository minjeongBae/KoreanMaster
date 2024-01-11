package koreanmaster.home;

import koreanmaster.board.post.PostDTO;
import koreanmaster.board.post.service.Show;
import koreanmaster.mypage.student.service.CheckStudent;
import koreanmaster.teachers.teacher.introduction.service.GetIntroduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    private final Show show;
    private final CheckStudent checkStudent;

    private final GetIntroduction getIntroduction;

    @Autowired
    public HomeController(Show show, CheckStudent checkStudent,
                          GetIntroduction getIntroduction){
        this.show = show;
        this.checkStudent = checkStudent;
        this.getIntroduction = getIntroduction;
    }
    @GetMapping("/my_page")
    public String myPage(HttpSession session, Model model) {
        if (session.getAttribute("userEmail") == null) return "not-user";
        String userEmail = (String) session.getAttribute("userEmail");
        model.addAttribute("email", userEmail);

        if(checkStudent.isStudent(userEmail)) {
            model.addAttribute("isStudent", true);
            return "my-page";
        }
        model.addAttribute("isStudent",false);
        return "my-page";
    }

    @GetMapping("/show_board")
    public String showBoard(HttpSession session, Model model) {
        model.addAttribute("signIn","false");
        if(session.getAttribute("userEmail")!=null) model.addAttribute("signIn","true");

        List<PostDTO> posts = show.getAll();
        model.addAttribute("posts", posts);
        return "show-board";
    }

    @GetMapping("/introduction")
    public String introduction(){
        return "introduction";
    }

    @GetMapping("/teachers")
    public String teachers(HttpServletRequest request, Model model) {
        if(request.getParameter("message")!=null)
            model.addAttribute("message",request.getParameter("message"));
        model.addAttribute("introductionDTOList", getIntroduction.getAll());
        return "teachers";
    }
}
