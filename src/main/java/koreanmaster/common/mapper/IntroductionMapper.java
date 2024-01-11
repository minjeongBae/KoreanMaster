package koreanmaster.common.mapper;

import koreanmaster.teachers.teacher.introduction.IntroductionDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IntroductionMapper {
    @Insert("INSERT INTO Introduction (name, brief, txt, img) " +
            "VALUES (#{name}, #{brief}, #{txt}, #{img})")
    void add(IntroductionDTO introduction);

    @Select("SELECT * FROM Introduction WHERE introduction_id = #{id}")
    IntroductionDTO getById(@Param("id") int id);

    @Select("SELECT * FROM Introduction")
    List<IntroductionDTO> getAll();

    @Update("UPDATE Introduction SET txt=#{newTxt} WHERE introduction_id=#{id}")
    void reviseTxt(@Param("id") int id, @Param("newTxt") String newTxt);

    @Update("UPDATE Introduction SET img=#{newImg} WHERE introduction_id=#{id}")
    void reviseImg(@Param("id") int id, @Param("newImg") String newImg);

    @Update("UPDATE Introduction SET brief=#{newBrief} WHERE introduction_id=#{id}")
    void reviseBrief(@Param("id") int id, @Param("newBrief") String newBrief);
}
