package koreanmaster.board.post.service;

import koreanmaster.board.post.dao.Update;
import koreanmaster.board.post.reply.ReplyDto;
import koreanmaster.board.post.reply.service.Upload;

import java.sql.SQLException;

public class AddReply {
    private final Upload uploadReplyTool;
    private final int postId;
    public AddReply(int postId, ReplyDto reply){
        this.postId = postId;
        this.uploadReplyTool = new Upload(reply);
    }

    public boolean run(){
        int value = uploadReplyTool.run();
        if(value==-1){
            return false;
        }

        try{
            Update updateTool = new Update();
            updateTool.addReply(this.postId, value);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
