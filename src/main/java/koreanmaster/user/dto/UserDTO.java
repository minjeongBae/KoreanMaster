package koreanmaster.user.dto;

public class UserDTO {
    private final String email;
    private final String password;

    public UserDTO(String email, String password){
        this.email = email;
        this.password = password;
    }
}
