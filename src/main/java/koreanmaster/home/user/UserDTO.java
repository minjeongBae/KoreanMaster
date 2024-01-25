package koreanmaster.home.user;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserDTO {
    private final String email;
    @Setter
    private String password;
    private final boolean isStudent;

    public UserDTO(String email, String password, boolean isStudent) {
        this.email = email;
        this.password = password;
        this.isStudent = isStudent;
    }
}
