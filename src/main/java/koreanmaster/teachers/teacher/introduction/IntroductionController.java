package koreanmaster.teachers.teacher.introduction;

import koreanmaster.teachers.teacher.introduction.service.GetIntroduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IntroductionController {
    private final GetIntroduction getIntroduction;
    @Autowired
    public IntroductionController(GetIntroduction getIntroduction) {
        this.getIntroduction = getIntroduction;
    }

    @PostMapping("/revise_introduction")
    public String reviseIntroduction(HttpSession session, Model model){
        String email = (String) session.getAttribute("userEmail");
        model.addAttribute("introduction", getIntroduction.getByEmail(email));

        return "revise-introduction";
    }
}
