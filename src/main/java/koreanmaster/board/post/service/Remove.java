package koreanmaster.board.post.service;

import koreanmaster.common.mapper.PostMapper;
import koreanmaster.common.mapper.ReplyMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class Remove {
    @Setter(onMethod_ = @Autowired)
    private PostMapper postMapper;

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper replyMapper;

    public boolean run(int postId) throws SQLException {
        try {
            int replyId = postMapper.getReply(postId);
            postMapper.remove(postId); // 자식테이블
            // 1은 dummy 값
            if(replyId>1) replyMapper.remove(replyId); // 부모테이블
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
