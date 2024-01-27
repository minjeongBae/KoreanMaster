package koreanmaster.teachers.teacher.introduction.service;

import koreanmaster.common.mapper.IntroductionMapper;
import koreanmaster.common.mapper.TeacherMapper;
import koreanmaster.teachers.teacher.introduction.IntroductionDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetIntroduction {
    @Setter(onMethod_ = @Autowired)
    private IntroductionMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private TeacherMapper tMapper;

    public List<IntroductionDTO> getAll(){
        List<IntroductionDTO> res;
        try{
            res = mapper.getAll();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return res;
    }

    public IntroductionDTO getById(int id){
        IntroductionDTO res;
        try{
            res = mapper.getById(id);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return res;
    }

    public IntroductionDTO getByEmail(String email){
        IntroductionDTO res;
        try{
            int id = tMapper.getIntroIdByEmail(email);
            res = mapper.getById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return res;
    }
}
