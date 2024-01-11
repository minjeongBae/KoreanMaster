package koreanmaster.teachers.teacher.introduction.service;

import koreanmaster.common.mapper.IntroductionMapper;
import koreanmaster.teachers.teacher.introduction.IntroductionDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddIntroduction {
    @Setter(onMethod_ = @Autowired)
    private IntroductionMapper mapper;
    public boolean add(IntroductionDTO introduction){
        try{
            mapper.add(introduction);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
