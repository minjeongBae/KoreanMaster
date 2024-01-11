package koreanmaster.board.post.service;

import koreanmaster.board.post.reply.ReplyDTO;
import koreanmaster.common.mapper.PostMapper;
import koreanmaster.common.mapper.ReplyMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AddReply {
    @Setter(onMethod_ = @Autowired)
    private PostMapper postMapper;

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper replyMapper;

    public boolean run(int postId, ReplyDTO reply){
        System.out.println(postId);
        try{
            replyMapper.upload(reply);
            postMapper.addReply(postId, reply.getReplyId());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
