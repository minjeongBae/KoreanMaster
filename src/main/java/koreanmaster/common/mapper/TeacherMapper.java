package koreanmaster.common.mapper;

import koreanmaster.teachers.teacher.SimpleTeacherDTO;
import koreanmaster.teachers.teacher.TeacherDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Insert("INSERT INTO Teacher (email, name, birth, eng_level, qualified, korean, how_long, phone) " +
            "VALUES (#{email}, #{name}, #{birth}, #{english}, #{qualified}, #{korean}, #{howLong}, #{phone})")
    void addTeacher(TeacherDTO teacher);


    List<SimpleTeacherDTO> allTeachers();

    void changeBirth(String email, String newDate);

    @Select("SELECT email FROM Teacher WHERE introduction_id = #{introductionId}")
    String getEmailByIntroId(int introductionId);
}
