package koreanmaster.teachers.applicationform.service;

import koreanmaster.common.mapper.ApplicationFormMapper;
import koreanmaster.common.mapper.SimpleFormMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class RemoveForm {
    @Setter(onMethod_ = @Autowired)
    private ApplicationFormMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private SimpleFormMapper simpleMapper;

    public boolean run(int formCode){
        try{
            mapper.remove(formCode);
            simpleMapper.remove(formCode);
            simpleMapper.rearrangeFormCode();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
