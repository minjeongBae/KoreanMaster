package koreanmaster.board.post.reply.service;

import koreanmaster.board.post.reply.dao.Insert;
import koreanmaster.board.post.reply.ReplyDto;
import koreanmaster.board.post.reply.dao.Select;

import java.sql.SQLException;

public class Upload {
    private final ReplyDto reply;

    public Upload(ReplyDto reply) {
        this.reply = reply;
    }

    public int run() {
        try {
            Insert insertTool = new Insert();
            insertTool.upload(this.reply);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }

        try{
            Select selectTool = new Select();
            int result = selectTool.getTheLast();
            if(result>0) return result;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
