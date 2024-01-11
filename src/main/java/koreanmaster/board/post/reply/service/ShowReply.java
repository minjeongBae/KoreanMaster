package koreanmaster.board.post.reply.service;

import koreanmaster.board.post.reply.ReplyDTO;
import koreanmaster.common.mapper.ReplyMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowReply {

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;

    public ReplyDTO run(int replyId) {
        return mapper.get(replyId);
    }
}
