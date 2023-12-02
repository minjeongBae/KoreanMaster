package koreanmaster.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping("/board")
    public String showBoard(){
        return "show-board";
    }

    @GetMapping("/post")
    public String showPost(){
        return "show-post";
    }

    @GetMapping("/upload_post")
    public String uploadPost(){
        return "upload-post";
    }

    @GetMapping("/upload_reply")
    public String uploadReply(){
        return "upload-reply";
    }
}
