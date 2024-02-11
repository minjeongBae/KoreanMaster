package koreanmaster.teachers.teacher.introduction.service;

import koreanmaster.common.mapper.IntroductionMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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

    public boolean reviseImg(int id, MultipartFile file){
        try{
            File newFile = new File("C:\\Users\\ssii6\\KoreanMaster\\images",file.getOriginalFilename());
            file.transferTo(newFile);
            mapper.reviseImg(id,newFile.getAbsolutePath());
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
