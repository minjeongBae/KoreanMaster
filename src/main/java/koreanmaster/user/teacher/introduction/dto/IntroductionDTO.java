package koreanmaster.user.teacher.introduction.dto;

public class IntroductionDTO {
    private final int introductionId;
    private final String brief;
    private final String txt;
    private final String img;

    public IntroductionDTO(int introductionId, String brief, String txt, String img){
        this.introductionId = introductionId;
        this.brief = brief;
        this.txt = txt;
        this.img = img;
    }
}
