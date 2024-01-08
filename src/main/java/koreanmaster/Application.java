package koreanmaster;

import koreanmaster.common.mapper.TimeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class Application {
    public static void main(String[] args) {

    }

    @Setter(onMethod_ = @Autowired)
    private TimeMapper mapper;

    @Test
    public void getTimeTest() {
        System.out.println("Now : "+mapper.getTest());
        log.info("Now : "+mapper.getTest());
    }
}

