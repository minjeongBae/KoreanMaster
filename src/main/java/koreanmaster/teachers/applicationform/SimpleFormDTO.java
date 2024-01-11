package koreanmaster.teachers.applicationform;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SimpleFormDTO {
    @Setter
    private int formCode;
    private final String teacherEmail;
    private final String studentEmail;
    private final int state;
    private String stateDetail;

    public SimpleFormDTO(int formCode, String teacherEmail, String studentEmail, int state){
        this.formCode = formCode;
        this.teacherEmail = teacherEmail;
        this.studentEmail = studentEmail;
        this.state = state;
        stateDetail = moreState();
    }

    private String moreState(){
        if(this.state==0) return "매칭 대기 중";
        if(this.state==1) return "상담 진행 중";
        if(this.state==2) return "수업 진행 중";
        return "수강 완료";
    }
}
