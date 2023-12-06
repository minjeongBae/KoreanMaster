package koreanmaster.common.config;

import koreanmaster.board.controller.BoardController;
import koreanmaster.home.controller.HomeController;
import koreanmaster.notuser.controller.NotUserController;
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
    public NotUserController myPageController(){
        return new NotUserController();
    }
}
