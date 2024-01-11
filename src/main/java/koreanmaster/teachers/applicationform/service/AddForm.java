package koreanmaster.teachers.applicationform.service;

import koreanmaster.common.mapper.ApplicationFormMapper;
import koreanmaster.common.mapper.SimpleFormMapper;
import koreanmaster.teachers.applicationform.ApplicationFormDTO;
import koreanmaster.teachers.applicationform.SimpleFormDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddForm {
    @Setter(onMethod_ = @Autowired)
    private ApplicationFormMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private SimpleFormMapper simpleMapper;

    public boolean run(SimpleFormDTO simpleForm, ApplicationFormDTO form){
        try{
            int code = simpleMapper.add(simpleForm);
            mapper.add(code, form);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
