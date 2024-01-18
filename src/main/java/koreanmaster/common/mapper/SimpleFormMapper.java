package koreanmaster.common.mapper;

import koreanmaster.teachers.applicationform.SimpleFormDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SimpleFormMapper {
    @Insert("INSERT INTO Simple_Form (teacher_email, student_email, state) " +
            "VALUES (#{form.teacherEmail}, #{form.studentEmail}, #{form.state})")
    @Options(useGeneratedKeys = true, keyProperty = "formCode")
    void add(@Param("form") SimpleFormDTO form);
    @Select("SELECT form_code FROM Simple_Form WHERE teacher_email = #{teacher} AND student_email = #{student}")
    List<Integer> getCode(@Param("teacher") String teacher, @Param("student") String student);

    @Select("SELECT * FROM Simple_Form WHERE teacher_email = #{teacher}")
    @Results({
            @Result(column = "form_code", property = "formCode"),
            @Result(column = "teacher_email", property = "teacherEmail"),
            @Result(column = "student_email", property = "studentEmail"),
            @Result(column = "state", property = "state")
    })
    List<SimpleFormDTO> getAllOfTeacher(@Param("teacher") String teacher);

    @Select("SELECT * FROM Simple_Form WHERE student_email = #{student}")
    @Results({
            @Result(column = "form_code", property = "formCode"),
            @Result(column = "teacher_email", property = "teacherEmail"),
            @Result(column = "student_email", property = "studentEmail"),
            @Result(column = "state", property = "state")
    })
    List<SimpleFormDTO> getAllOfStudent(@Param("student") String student);
}
