package koreanmaster.teachers.teacher;

import koreanmaster.home.user.UserDTO;
import lombok.Getter;

@Getter
public class TeacherDTO extends UserDTO {
    private final String name;
    private final String birth;
    private final int english;
    private final boolean isQualified;
    private final boolean korean;
    private final int howLong;
    private final String phone;
    private int introductionId;

    public TeacherDTO(String email, String password, String name, String birth, int english,
                      boolean qualified,
                      boolean korean, int howLong, String phone, int introductionId) {
        super(email, password, false);
        this.name = name;
        this.birth = birth;
        this.english = english;
        this.isQualified = qualified;
        this.korean = korean;
        this.howLong = howLong;
        this.phone = phone;
        this.introductionId = introductionId;
    }

    public void setIntroductionId(int introductionId) {
        this.introductionId = introductionId;
    }
}
