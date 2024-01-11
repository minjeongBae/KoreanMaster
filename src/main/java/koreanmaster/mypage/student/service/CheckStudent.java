package koreanmaster.mypage.student.service;

import koreanmaster.common.mapper.StudentMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckStudent {
    @Setter(onMethod_ = @Autowired)
    private StudentMapper mapper;

    public boolean isStudent(String email){
        String getEmail = mapper.isStudent(email);
        return getEmail!=null;
    }
}
