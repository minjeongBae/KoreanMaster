package koreanmaster.board.post.service;

import koreanmaster.board.post.dao.Select;
import koreanmaster.common.mapper.PostMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;


@Component
public class Revise {
    @Setter(onMethod_ = @Autowired)
    private PostMapper mapper;
    public boolean run(int postId, String newContent) throws SQLException {
        Select selectTool = new Select();
        if (selectTool.notNullReplyId(postId)) return false;

        try {
            mapper.reviseContent(postId, newContent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
