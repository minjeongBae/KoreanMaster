package koreanmaster.common.mapper;

import koreanmaster.mypage.student.StudentDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO Student (email, name, birth, eng_level, phone) " +
            "VALUES (#{email}, #{name}, #{birth}, #{english}, #{phone})")
    void addStudent(StudentDTO student);

    @Select("SELECT email FROM Student WHERE email = #{email}")
    String isStudent(String email);

    @Update("UPDATE Student SET birth = #{newDate} WHERE email = #{email}")
    void changeBirth(@Param("email") String email, @Param("newDate") String newDate);

    @Update("UPDATE Student SET name = #{newName} WHERE email = #{email}")
    void changeName(@Param("email") String email, @Param("newName") String newName);

    @Update("UPDATE Student SET phone = #{newPhone} WHERE email = #{email}")
    void changePhone(@Param("email") String email, @Param("newPhone") String newPhone);

    @Update("UPDATE Student SET eng_level = #{newEngLevel} WHERE email = #{email}")
    void changeEngLevel(@Param("email") String email, @Param("newEngLevel") String newEngLevel);

}
