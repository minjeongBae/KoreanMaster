package koreanmaster.mypage.controller;

import koreanmaster.board.post.PostDTO;
import koreanmaster.board.post.service.Show;
import koreanmaster.home.user.dao.Update;
import koreanmaster.home.user.service.CheckUser;
import koreanmaster.mypage.student.service.CheckStudent;
import koreanmaster.teachers.teacher.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class MyPageController {
    private final Show show;
    private final CheckUser checkUser;
    private final CheckStudent checkStudent;
    @Autowired
    public MyPageController(Show show, CheckUser checkUser,
                            CheckStudent checkStudent){
        this.show = show;
        this.checkUser = checkUser;
        this.checkStudent = checkStudent;
    }
    @GetMapping("/revise_user_info")
    public String reviseUserInfo(HttpSession session, Model model) {
        String nowUser = (String) session.getAttribute("userEmail");
        model.addAttribute("isStudent", checkStudent.isStudent(nowUser));

        return "revise-user-info";
    }

    @PostMapping("/change_pw")
    public String completeChangePw(HttpServletRequest rq, HttpSession session, Model model) throws SQLException {
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

        Update updateTool = new Update();
        updateTool.changePw(userEmail, oldPw, rq.getParameter("new_password"));
        model.addAttribute("message", "비밀번호를 변경하였습니다.");
        return "revise-user-info";
    }

    @PostMapping("/change_birth")
    public String completeChangeBirth(HttpServletRequest rq, HttpSession session, Model model) throws SQLException {
        String nowUser = (String) session.getAttribute("userEmail");
        boolean isStudent = checkStudent.isStudent(nowUser);

        model.addAttribute("isStudent", isStudent);
        String birth = rq.getParameter("birth");
        if(isStudent){
            koreanmaster.mypage.student.dao.Update studentUpdateTool
                    = new koreanmaster.mypage.student.dao.Update(nowUser);
            studentUpdateTool.changeBirth(birth);

            model.addAttribute("message", "생일이 변경되었습니다.");
            return "revise-user-info";
        }

        new TeacherDAO().changeBirth(nowUser, birth);
        model.addAttribute("message", "생일이 변경되었습니다.");
        return "revise-user-info";
    }

    @GetMapping("/my_posts")
    public String showMyPosts(HttpSession session, Model model){
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
    public String showClasses(HttpSession session, Model model) throws SQLException {
        // student version
        String email = (String) session.getAttribute("userEmail");
        koreanmaster.teachers.applicationform.simpledao.Select selectTool
                = new koreanmaster.teachers.applicationform.simpledao.Select();
        model.addAttribute("classes", selectTool.getAllOfStudent(email));

        return "show-classes";
    }

    @GetMapping("/show_application")
    public String showApplication(HttpSession session, Model model) throws SQLException {
        // teacher version
        String email = (String) session.getAttribute("userEmail");

        koreanmaster.teachers.applicationform.simpledao.Select selectTool
                = new koreanmaster.teachers.applicationform.simpledao.Select();
        model.addAttribute("applications", selectTool.getAllOfTeacher(email));

        return "show-application";
    }
}
