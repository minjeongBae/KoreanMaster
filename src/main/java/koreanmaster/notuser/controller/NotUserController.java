package koreanmaster.notuser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotUserController {
    @GetMapping("/sign_in")
    public String signIn() {
        return "sign-in";
    }

    @GetMapping("/sign_up")
    public String signUp() {
        return "sign-up";
    }
}
