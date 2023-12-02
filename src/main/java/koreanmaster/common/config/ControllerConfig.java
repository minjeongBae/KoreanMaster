package koreanmaster.common.config;

import koreanmaster.board.controller.BoardController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
    @Bean
    public BoardController boardController(){
        return new BoardController();
    }
}
