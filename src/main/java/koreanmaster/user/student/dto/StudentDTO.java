package koreanmaster.user.student.dto;

import koreanmaster.user.dto.UserDTO;
import lombok.Getter;

@Getter
public class StudentDTO extends UserDTO {
    private final String name;
    private final String birth;
    private final int level;
    private final String phone;
    public StudentDTO(String email, String pw, String name,
                      String birth, int level, String phone){
        super(email,pw, true);
        this.name = name;
        this.birth = birth;
        this.level = level;
        this.phone = phone;
    }
}
