package koreanmaster.teachers.teacher.service;

import koreanmaster.common.mapper.TeacherMapper;
import koreanmaster.teachers.teacher.SimpleTeacherDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckTeacher {
    @Setter(onMethod_ = @Autowired)
    private TeacherMapper mapper;

    public String getEmailByIntroId(int introductionId){
        String res = null;
        try{
            res = mapper.getEmailByIntroId(introductionId);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return res;
        }
        return res;
    }

    public List<SimpleTeacherDTO> allTeachers(){
        List<SimpleTeacherDTO> res;
        try{
            res = mapper.allTeachers();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return res;
    }

    public boolean changeBirth(String email, String newDate){
        try {
            mapper.changeBirth(email, newDate);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
