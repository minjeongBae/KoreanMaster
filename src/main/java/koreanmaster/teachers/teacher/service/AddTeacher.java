package koreanmaster.teachers.teacher.service;

import koreanmaster.common.mapper.TeacherMapper;
import koreanmaster.teachers.teacher.TeacherDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddTeacher {
    @Setter(onMethod_ = @Autowired)
    private TeacherMapper mapper;

    public boolean run(TeacherDTO teacher){
        try{
            mapper.addTeacher(teacher);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
