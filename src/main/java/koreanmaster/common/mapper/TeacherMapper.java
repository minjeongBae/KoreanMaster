package koreanmaster.common.mapper;

import koreanmaster.teachers.teacher.SimpleTeacherDTO;
import koreanmaster.teachers.teacher.TeacherDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Insert("INSERT INTO Teacher (email, name, birth, eng_level, qualified, korean, how_long, phone) " +
            "VALUES (#{email}, #{name}, #{birth}, #{english}, #{qualified}, #{korean}, #{howLong}, #{phone})")
    void addTeacher(TeacherDTO teacher);

    @Select("SELECT * FROM Teacher")
    List<SimpleTeacherDTO> allTeachers();

    @Select("SELECT introduction_id FROM Teacher WHERE email=#{email}")
    int getIntroIdByEmail(@Param("email") String email);

    void changeBirth(String email, String newDate);

    @Select("SELECT email FROM Teacher WHERE introduction_id = #{introductionId}")
    String getEmailByIntroId(int introductionId);
}
