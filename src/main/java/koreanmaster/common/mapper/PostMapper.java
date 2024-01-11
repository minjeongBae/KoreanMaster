package koreanmaster.common.mapper;

import koreanmaster.board.post.PostDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO Post (title, writer, registration_date, content, reply_id) "
            + "VALUES (#{title}, #{writer}, #{registrationDate}, #{content}, 1)")
    void upload(PostDTO post);

    @Select("SELECT * FROM Post WHERE post_id = #{postId}")
    PostDTO show(int postId);
    @Delete("DELETE FROM Post WHERE post_id = #{postId}")
    void remove(int postId);

    @Update("UPDATE Post SET reply_id = #{replyId} WHERE post_id = #{postId}")
    void addReply(@Param("postId") int postId, @Param("replyId") int replyId);

    @Update("UPDATE Post SET content = #{content} WHERE post_id = #{postId}")
    void reviseContent(@Param("postId") int postId, @Param("content") String content);

    @Select("SELECT reply_id FROM Post WHERE post_id= #{postId}")
    int getReply(int postId);

    @Select("SELECT post_id FROM Post WHERE post_id > #{postId} ORDER BY post_id ASC LIMIT 1")
    Integer getNext(int postId);

    @Select("SELECT post_id FROM Post WHERE post_id < #{postId} ORDER BY post_id DESC LIMIT 1")
    Integer getPrev(int postId);

    @Select("SELECT * FROM Post WHERE writer = #{email}")
    List<PostDTO> getByEmail(String email);

    @Select("SELECT * FROM Post")
    List<PostDTO> getAll();
}
