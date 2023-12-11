package koreanmaster.common.config;

import koreanmaster.board.controller.BoardController;
import koreanmaster.home.controller.HomeController;
import koreanmaster.mypage.controller.SignInController;
import koreanmaster.mypage.controller.SignUpController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

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
    public SignUpController signUpController() throws SQLException {
        return new SignUpController();
    }

    @Bean
    public SignInController signInController(){
        return new SignInController();
    }
}
