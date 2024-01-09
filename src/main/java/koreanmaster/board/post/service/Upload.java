package koreanmaster.board.post.service;

import koreanmaster.board.post.PostDTO;
import koreanmaster.common.mapper.PostMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Upload {

    @Setter(onMethod_ = @Autowired)
    private PostMapper mapper;

    public boolean run(PostDTO post) {
        try{
            mapper.upload(post);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
