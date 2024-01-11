package koreanmaster.board.post.service;

import koreanmaster.common.mapper.PostMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Revise {
    @Setter(onMethod_ = @Autowired)
    private PostMapper mapper;
    public boolean run(int postId, String newContent) {
        try {
            mapper.reviseContent(postId, newContent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
