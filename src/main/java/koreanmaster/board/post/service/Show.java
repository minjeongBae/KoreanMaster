package koreanmaster.board.post.service;

import koreanmaster.board.post.PostDTO;
import koreanmaster.board.post.dao.Select;
import koreanmaster.board.post.reply.ReplyDTO;

import java.sql.SQLException;
import java.util.List;

public class Show {
    private int postId;
    public Show(int postId){
        this.postId = postId;
    }
    public Show(){}
    public PostDTO run() throws SQLException {
        Select selectTool  = new Select();
        return selectTool.get(this.postId);
    }

    private boolean hasReply() throws SQLException {
        return new Select().notNullReplyId(this.postId);
    }

    public ReplyDTO getReply() throws SQLException {
        if(!hasReply()) return null;

        try{
            int replyId = new Select().getReplyId(this.postId);
            ReplyDTO reply = new koreanmaster.board.post.reply.service.Show(replyId).run();
            return reply;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
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

    public boolean isLast() throws SQLException {
        Select selectTool = new Select();
        return selectTool.getTheLast() == this.postId;
    }

}
