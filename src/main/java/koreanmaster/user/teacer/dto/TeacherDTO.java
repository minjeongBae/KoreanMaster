package koreanmaster.user.teacer.dto;

import koreanmaster.user.dto.UserDTO;

public class TeacherDTO extends UserDTO {
    private final String name;
    private final String birth;
    private final boolean qualified;
    private final String phone;
    public TeacherDTO(String email, String password, String name, String birth,
                      boolean qualified, String phone, boolean isStudent) {
        super(email, password, isStudent);
        this.name = name;
        this.birth = birth;
        this.qualified = qualified;
        this.phone = phone;
    }
}
