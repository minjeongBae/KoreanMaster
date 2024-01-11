package koreanmaster.board.post.service;

import koreanmaster.board.post.PostDTO;
import koreanmaster.common.mapper.PostMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class Show {

    @Setter(onMethod_ = @Autowired)
    private PostMapper postMapper;
    public PostDTO run(int postId) {
        return postMapper.show(postId);
    }

    public Integer getNextId(int postId){
        return postMapper.getNext(postId);
    }

    public Integer getPrevId(int postId){
        return postMapper.getPrev(postId);
    }

    public List<PostDTO> getByEmail(String userEmail){
        try{
            return postMapper.getByEmail(userEmail);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<PostDTO> getAll(){
        try{
            return postMapper.getAll();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
