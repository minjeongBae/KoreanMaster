package koreanmaster.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("koreanmaster.common.mapper")
public class MyBatisConfig {

}
