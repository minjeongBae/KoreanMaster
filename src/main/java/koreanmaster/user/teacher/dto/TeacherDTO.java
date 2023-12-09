package koreanmaster.user.teacher.dto;

import koreanmaster.user.dto.UserDTO;
import lombok.Getter;

@Getter
public class TeacherDTO extends UserDTO {
    private final String name;
    private final String birth;
    private final boolean isQualified;
    private final String phone;
    public TeacherDTO(String email, String password, String name, String birth,
                      boolean qualified, String phone) {
        super(email, password, false);
        this.name = name;
        this.birth = birth;
        this.isQualified = qualified;
        this.phone = phone;
    }
}
