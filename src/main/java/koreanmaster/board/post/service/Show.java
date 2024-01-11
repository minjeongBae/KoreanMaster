package koreanmaster.board.post.service;

import koreanmaster.board.post.PostDTO;
import koreanmaster.board.post.dao.Select;
import koreanmaster.board.post.reply.ReplyDTO;
import koreanmaster.board.post.reply.service.ShowReply;
import koreanmaster.common.mapper.PostMapper;
import koreanmaster.common.mapper.ReplyMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
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
            Select selectTool = new Select();
            return selectTool.getByEmail(userEmail);
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<PostDTO> getAll(){
        try{
            Select selectTool= new Select();
            return selectTool.getAll();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean isLast(int postId) throws SQLException {
        Select selectTool = new Select();
        return selectTool.getTheLast() == postId;
    }

}
