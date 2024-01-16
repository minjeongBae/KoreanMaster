package koreanmaster.mypage.controller;

import koreanmaster.board.post.PostDTO;
import koreanmaster.board.post.service.Show;
import koreanmaster.home.user.service.ChangeUserInfo;
import koreanmaster.home.user.service.CheckUser;
import koreanmaster.mypage.student.service.CheckStudent;
import koreanmaster.teachers.applicationform.service.ShowForm;
import koreanmaster.teachers.teacher.service.CheckTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyPageController {
    private final Show show;
    private final CheckUser checkUser;
    private final CheckStudent checkStudent;
    private final ChangeUserInfo changeUserInfo;
    private final CheckTeacher checkTeacher;
    private final ShowForm showForm;

    @Autowired
    public MyPageController(Show show, CheckUser checkUser,
                            CheckStudent checkStudent, CheckTeacher checkTeacher,
                            ChangeUserInfo changeUserInfo, ShowForm showForm){
        this.show = show;
        this.checkUser = checkUser;
        this.checkStudent = checkStudent;
        this.changeUserInfo = changeUserInfo;
        this.checkTeacher = checkTeacher;
        this.showForm = showForm;
    }
    @GetMapping("/revise_user_info")
    public String reviseUserInfo(HttpSession session, Model model) {
        String nowUser = (String) session.getAttribute("userEmail");
        model.addAttribute("isStudent", checkStudent.isStudent(nowUser));

        return "revise-user-info";
    }

    @PostMapping("/change_pw")
    public String completeChangePw(HttpServletRequest rq, HttpSession session, Model model) {
        String oldPw = rq.getParameter("old_password");
        String userEmail = (String) session.getAttribute("userEmail");
        String newPw1 = rq.getParameter("new_password");
        String newPw2 = rq.getParameter("chk_password");

        boolean signIn = checkUser.signIn(userEmail, oldPw);
        model.addAttribute("isStudent", checkStudent.isStudent(userEmail));

        if(!newPw1.equals(newPw2) || !signIn){
            model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
            return "revise-user-info";
        }

        if(newPw1.equals(oldPw)){
            model.addAttribute("message", "현재 비밀번호와 동일한 비밀번호로는 변경할 수 없습니다.");
            return "revise-user-info";
        }

        changeUserInfo.changePw(userEmail, oldPw, rq.getParameter("new_password"));
        model.addAttribute("message", "비밀번호를 변경하였습니다.");
        return "revise-user-info";
    }

    @PostMapping("/change_birth")
    public String completeChangeBirth(HttpServletRequest rq, HttpSession session, Model model) {
        String nowUser = (String) session.getAttribute("userEmail");
        boolean isStudent = checkStudent.isStudent(nowUser);

        model.addAttribute("isStudent", isStudent);
        String birth = rq.getParameter("birth");
        model.addAttribute("message", "생일이 변경되었습니다.");
        if(isStudent){
            if(!checkStudent.changeBirth(nowUser,birth))
                model.addAttribute("message", "생일변경에 실패하였습니다. 다시 시도해주세요.");
            return "revise-user-info";
        }

        if(!checkTeacher.changeBirth(nowUser, birth))
            model.addAttribute("message", "생일변경에 실패하였습니다. 다시 시도해주세요.");
        return "revise-user-info";
    }

    @GetMapping("/my_posts")
    public String showMyPosts(HttpSession session, Model model) {
        String userEmail = (String) session.getAttribute("userEmail");
        List<PostDTO> myPosts = show.getByEmail(userEmail);
        model.addAttribute("myPosts", myPosts);
        model.addAttribute("email", userEmail);

        if(checkStudent.isStudent(userEmail)) {
            model.addAttribute("isStudent", true);
            return "my-page";
        }
        model.addAttribute("isStudent",false);

        return "my-page";
    }

    @GetMapping("/show_classes")
    public String showClasses(HttpSession session, Model model) {
        // student version
        String email = (String) session.getAttribute("userEmail");
        model.addAttribute("classes", showForm.getAllOfStudent(email));

        return "show-classes";
    }

    @GetMapping("/show_applications")
    public String showApplications(HttpSession session, Model model) {
        // teacher version
        String email = (String) session.getAttribute("userEmail");
        model.addAttribute("applications", showForm.getAllOfTeacher(email));

        return "show-applications";
    }
}
