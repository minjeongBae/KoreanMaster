package koreanmaster.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/my_page")
    public String myPage() {
        return "my-page";
    }

    @GetMapping("/show_board")
    public String showBoard() {
        return "show-board";
    }
}
