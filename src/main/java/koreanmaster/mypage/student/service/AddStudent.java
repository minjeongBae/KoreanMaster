package koreanmaster.mypage.student.service;

import koreanmaster.common.mapper.StudentMapper;
import koreanmaster.mypage.student.StudentDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddStudent {
    @Setter(onMethod_ = @Autowired)
    private StudentMapper mapper;
    public boolean run(StudentDTO student){
        try{
            mapper.addStudent(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
