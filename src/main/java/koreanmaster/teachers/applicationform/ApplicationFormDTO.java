package koreanmaster.teachers.applicationform;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ApplicationFormDTO {
    @Setter
    private int formCode;
    @Setter
    private String teacherEmail;
    @Setter
    private String studentEmail;
    private final int frequency;
    private final int time;
    private final int level;
    @Setter
    private int root;
    private final int state;
    private final int counselTime;
    @Setter
    private String addition;

    public ApplicationFormDTO(String teacherEmail, String studentEmail,
                              int frequency, int time, int level, String root,
                              int state, int counselTime){
        this.formCode = formCode;
        this.teacherEmail = teacherEmail;
        this.studentEmail = studentEmail;
        this.frequency = frequency;
        this.time = time;
        setRootByStr(root);
        this.level = level;
        this.state = state;
        this.counselTime = counselTime;
    }

    public ApplicationFormDTO(String teacherEmail, String studentEmail,
                              int frequency, int time, int level, String root,
                              int state, int counselTime, String addition){
        this.teacherEmail = teacherEmail;
        this.studentEmail = studentEmail;
        this.frequency = frequency;
        this.time = time;
        setRootByStr(root);
        this.level = level;
        this.state = state;
        this.counselTime = counselTime;
        this.addition = addition;
    }

    public ApplicationFormDTO(int formCode,int frequency, int time,
                              int level, int root, int state,
                              int counselTime, String addition){
        this.formCode = formCode;
        this.frequency = frequency;
        this.time = time;
        this.level = level;
        this.root = root;
        this.state = state;
        this.counselTime = counselTime;
        this.addition = addition;
    }

    public void setRootByStr(String str){
        if(str.equals("voice")) {
            this.root = 1;
            return;
        }
        if(str.equals("text")){
            this.root = 2;
            return;
        }
        if(str.equals("video")) {
            this.root = 3;
            return;
        }
        this.root = 0;
    }
}
