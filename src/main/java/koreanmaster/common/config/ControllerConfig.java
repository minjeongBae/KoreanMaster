package koreanmaster.common.config;

import koreanmaster.board.Controller;
import koreanmaster.home.controller.HomeController;
import koreanmaster.mypage.controller.MyPageController;
import koreanmaster.mypage.controller.SignInController;
import koreanmaster.mypage.controller.SignUpController;
import koreanmaster.teachers.controller.TeachersController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class ControllerConfig {
    @Bean
    public Controller boardController() {
        return new Controller();
    }

    @Bean
    public HomeController homeController() {
        return new HomeController();
    }

    @Bean
    public SignUpController signUpController() throws SQLException {
        return new SignUpController();
    }

    @Bean
    public SignInController signInController() {
        return new SignInController();
    }

    @Bean
    public MyPageController myPageController(){
        return new MyPageController();
    }
    @Bean
    public TeachersController teachersController() {
        return new TeachersController();
    }
}
