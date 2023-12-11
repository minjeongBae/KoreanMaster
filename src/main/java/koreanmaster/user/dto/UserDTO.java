package koreanmaster.user.dto;

import lombok.Getter;

@Getter
public class UserDTO {
    private final String email;
    private final String password;
    private final boolean isStudent;

    public UserDTO(String email, String password, boolean isStudent) {
        this.email = email;
        this.password = password;
        this.isStudent = isStudent;
    }
}
