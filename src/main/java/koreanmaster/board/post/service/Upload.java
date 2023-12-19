package koreanmaster.board.post.service;

import koreanmaster.board.post.PostDto;
import koreanmaster.board.post.dao.Insert;

import java.sql.SQLException;

public class Upload {
    private final PostDto post;
    public Upload(PostDto post){
        this.post = post;
    }
    public boolean run() {
        try{
            Insert insertTool = new Insert();
            insertTool.upload(this.post);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
