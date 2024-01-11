package koreanmaster.home.user.service;

import koreanmaster.common.mapper.UserMapper;
import koreanmaster.home.user.UserDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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
        UserDTO user = mapper.signIn(email, pw);
        return user != null;
    }
}
