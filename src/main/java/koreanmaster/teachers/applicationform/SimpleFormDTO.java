package koreanmaster.teachers.applicationform;

import lombok.Getter;

@Getter
public class SimpleFormDTO {
    private final String teacherEmail;
    private final String studentEmail;
    private final int state;

    public SimpleFormDTO(String teacherEmail, String studentEmail, int state){
        this.teacherEmail = teacherEmail;
        this.studentEmail = studentEmail;
        this.state = state;
    }
}
