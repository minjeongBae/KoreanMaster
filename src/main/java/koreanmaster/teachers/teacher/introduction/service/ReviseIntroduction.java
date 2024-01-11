package koreanmaster.teachers.teacher.introduction.service;

import koreanmaster.common.mapper.IntroductionMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviseIntroduction {
    @Setter(onMethod_ = @Autowired)
    private IntroductionMapper mapper;
    public boolean reviseTxt(int id, String newTxt){
        try{
            mapper.reviseTxt(id,newTxt);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean reviseImg(int id, String newImg){
        try{
            mapper.reviseImg(id,newImg);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean reviseBrief(int id, String newBrief){
        try{
            mapper.reviseBrief(id,newBrief);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
