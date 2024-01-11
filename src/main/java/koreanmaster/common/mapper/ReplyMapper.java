package koreanmaster.common.mapper;

import koreanmaster.board.post.reply.ReplyDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ReplyMapper {
    @Insert("INSERT INTO Reply (writer, registration_date, content) " +
            "VALUES (#{reply.writer}, #{reply.registrationDate}, #{reply.content})")
    @Options(useGeneratedKeys = true, keyProperty = "replyId")
    void upload(@Param("reply") ReplyDTO reply);

    @Delete("DELETE FROM Reply WHERE reply_id = #{replyId}")
    void remove(int replyId);

    @Select("SELECT * FROM Reply WHERE reply_id = #{replyId}")
    ReplyDTO get(int replyId);
}
