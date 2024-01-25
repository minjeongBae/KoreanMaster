package koreanmaster.common.mapper;

import koreanmaster.home.user.UserDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO User (email, password, is_student) VALUES (#{email}, #{password}, #{student})")
    void add(UserDTO newUser);

    @Select("SELECT email FROM User WHERE email= #{email}")
    String findByEmail(String email);

    @Select("SELECT email FROM Manager WHERE email = #{email}")
    String isManager(String email);
    @Update("UPDATE User SET password = #{newPW} WHERE email = #{email}")
    void changePw(@Param("email") String email, @Param("newPW") String newPW);

    @Select("SELECT password FROM User WHERE email = #{email}")
    String getPw(@Param("email") String email);
}
