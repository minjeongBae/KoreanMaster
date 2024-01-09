package koreanmaster.common.mapper;

import koreanmaster.board.post.PostDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO Post (title, writer, registration_date, content) "
            + "VALUES (#{title}, #{writer}, #{registrationDate}, #{content})")
    void upload(PostDTO post);
}
