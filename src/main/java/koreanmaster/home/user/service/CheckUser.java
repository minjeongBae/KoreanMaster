package koreanmaster.home.user.service;

import koreanmaster.common.mapper.UserMapper;
import koreanmaster.home.user.UserDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CheckUser {
    @Setter(onMethod_ = @Autowired)
    private UserMapper mapper;

    public boolean isAbleEmail(String email){
        String getEmail = mapper.findByEmail(email);
        return (getEmail==null);
    }
    public boolean signIn(String email, String pw){
        if(mapper.findByEmail(email)!=null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder.matches(pw,mapper.getPw(email));
        }
        return false;
    }

    public boolean isManager(String email){
        String getEmail = mapper.isManager(email);
        return getEmail != null;
    }
}
