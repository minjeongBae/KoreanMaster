package koreanmaster.common.config;

import koreanmaster.board.controller.BoardController;
import koreanmaster.home.controller.HomeController;
import koreanmaster.mypage.controller.MyPageController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
    @Bean
    public BoardController boardController(){
        return new BoardController();
    }

    @Bean
    public HomeController homeController(){
        return new HomeController();
    }

    @Bean
    public MyPageController myPageController(){
        return new MyPageController();
    }
}
