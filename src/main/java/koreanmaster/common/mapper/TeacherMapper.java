package koreanmaster.common.mapper;

import koreanmaster.teachers.teacher.TeacherDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface TeacherMapper {
    @Insert("INSERT INTO Teacher (email, name, birth, eng_level, qualified, korean, how_long, phone) " +
            "VALUES (#{email}, #{name}, #{birth}, #{english}, #{qualified}, #{korean}, #{howLong}, #{phone})")
    void addTeacher(TeacherDTO teacher);
}
