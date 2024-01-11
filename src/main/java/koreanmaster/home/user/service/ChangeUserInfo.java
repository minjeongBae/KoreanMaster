package koreanmaster.home.user.service;

import koreanmaster.common.mapper.UserMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangeUserInfo {
    @Setter(onMethod_ = @Autowired)
    private UserMapper mapper;

    public boolean changePw(String email, String oldPw, String newPw){
        try {
            mapper.changePw(email, oldPw, newPw);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
