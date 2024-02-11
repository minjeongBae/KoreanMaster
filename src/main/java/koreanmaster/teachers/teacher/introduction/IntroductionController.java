package koreanmaster.teachers.teacher.introduction;

import koreanmaster.teachers.teacher.introduction.service.GetIntroduction;
import koreanmaster.teachers.teacher.introduction.service.ReviseIntroduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class IntroductionController {
    private final GetIntroduction getIntroduction;
    private final ReviseIntroduction reviseIntroduction;
    @Autowired
    public IntroductionController(GetIntroduction getIntroduction, ReviseIntroduction reviseIntroduction) {
        this.getIntroduction = getIntroduction;
        this.reviseIntroduction = reviseIntroduction;
    }

    @PostMapping("/revise_introduction")
    public String reviseIntroduction(HttpSession session, Model model){
        String email = (String) session.getAttribute("userEmail");
        model.addAttribute("introduction", getIntroduction.getByEmail(email));

        return "revise-introduction";
    }

    @PostMapping("/admin/uploadFile")
    public String successReviseImg(@RequestParam("file") MultipartFile file,
                                   HttpServletRequest rq, Model model) {
        int id = Integer.parseInt(rq.getParameter("origin"));
        reviseIntroduction.reviseImg(id, file);
        model.addAttribute("introduction", getIntroduction.getById(id));
        return "revise-introduction";
    }
}
