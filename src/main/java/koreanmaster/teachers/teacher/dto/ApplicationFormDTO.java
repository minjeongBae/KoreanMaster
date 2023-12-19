package koreanmaster.teachers.teacher.dto;

import lombok.Getter;

@Getter
public class ApplicationFormDTO {
    private final String studentEmail;
    private final int frequency;
    private final int time;
    private final String root;
    private final int level;
    private final String phone;
    private final int counselTime;
    private final String addition;

    public ApplicationFormDTO(String studentEmail, int frequency, int time, String root, int level,
                              String phone, int counselTime, String addition){
        this.studentEmail = studentEmail;
        this.frequency = frequency;
        this.time = time;
        this.root = root;
        this.level = level;
        this.phone = phone;
        this.counselTime = counselTime;
        this.addition = addition;
    }

}
