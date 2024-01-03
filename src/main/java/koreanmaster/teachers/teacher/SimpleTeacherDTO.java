package koreanmaster.teachers.teacher;

import lombok.Getter;

@Getter
public class SimpleTeacherDTO {
    private final String email;
    private final boolean qualified;
    private final int introductionId;

    public SimpleTeacherDTO(String email, boolean qualified, int introduction){
        this.email = email;
        this.qualified = qualified;
        this.introductionId = introduction;
    }
}
