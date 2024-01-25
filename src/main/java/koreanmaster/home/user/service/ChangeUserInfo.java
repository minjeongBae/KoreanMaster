package koreanmaster.home.user.service;

import koreanmaster.common.mapper.UserMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ChangeUserInfo {
    @Setter(onMethod_ = @Autowired)
    private UserMapper mapper;

    public boolean changePw(String email, String oldPw, String newPw){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedNewPw = encoder.encode(newPw);
        try {
            BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
            if(pwEncoder.matches(oldPw, mapper.getPw(email))){
                mapper.changePw(email, encodedNewPw);
                return true;
            }
            System.out.println("비밀번호 틀림");
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
