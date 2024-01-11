package koreanmaster.common.mapper;

import koreanmaster.mypage.student.StudentDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO Student (email, name, birth, eng_level, phone) " +
            "VALUES (#{email}, #{name}, #{birth}, #{english}, #{phone})")
    void addStudent(StudentDTO student);

}
