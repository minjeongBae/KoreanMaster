package koreanmaster.common.mapper;

import koreanmaster.home.user.UserDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO User (email, password, is_student) VALUES (#{email}, #{password}, #{student})")
    void add(UserDTO newUser);

    @Select("SELECT email FROM User WHERE email= #{email}")
    String findByEmail(String email);

    @Select("SELECT * FROM User WHERE email = #{email} AND password = #{password}")
    UserDTO signIn(@Param("email") String email, @Param("password") String password);

    @Select("SELECT email FROM Manager WHERE email = #{email}")
    String isManager(String email);
    @Update("UPDATE User SET password = #{newPW} WHERE email = #{email} AND password = #{oldPW}")
    void changePw(@Param("email") String email, @Param("oldPW") String oldPW, @Param("newPW") String newPW);
}
