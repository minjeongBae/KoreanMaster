package koreanmaster.teachers.applicationform;

import lombok.Getter;

@Getter
public class ApplicationFormDTO {
    private final String teacherEmail;
    private final String studentEmail;
    private final int frequency;
    private final int time;
    private final String root;
    private final int level;
    private final int state;
    private final int counselTime;
    private final String addition;

    public ApplicationFormDTO(String teacherEmail, String studentEmail, int frequency,
                              int time, String root, int level,
                              int state, int counselTime, String addition){
        this.teacherEmail = teacherEmail;
        this.studentEmail = studentEmail;
        this.frequency = frequency;
        this.time = time;
        this.root = root;
        this.level = level;
        this.state = state;
        this.counselTime = counselTime;
        this.addition = addition;
    }

}