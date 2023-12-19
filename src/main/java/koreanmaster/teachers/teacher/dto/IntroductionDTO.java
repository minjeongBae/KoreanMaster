package koreanmaster.teachers.teacher.dto;

import lombok.Getter;

@Getter
public class IntroductionDTO {
    private final int introductionId;
    private final String name;
    private final String finalAcademicAbility;
    private final String major;
    private final boolean koreanTeacherCertificate;
    private final String brief;
    private final String txt;
    private final String img;

    public IntroductionDTO(int introductionId, String name,
                           String finalAcademicAbility, String major,
                           boolean koreanTeacherCertificate,
                           String brief, String txt, String img){
        this.introductionId = introductionId;
        this.name = name;
        this.finalAcademicAbility = finalAcademicAbility;
        this.major = major; // null 가능
        this.koreanTeacherCertificate = koreanTeacherCertificate;
        this.brief = brief;
        this.txt = txt;
        this.img = img;
    }
}
