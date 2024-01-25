package koreanmaster.home.user.service;

import koreanmaster.common.mapper.UserMapper;
import koreanmaster.home.user.UserDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AddUser {
    @Setter(onMethod_ = @Autowired)
    private UserMapper mapper;

    public boolean run(UserDTO user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode(user.getPassword());
        user.setPassword(encoded);
        try{
            mapper.add(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
