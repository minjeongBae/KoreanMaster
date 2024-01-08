package koreanmaster.common.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("SELECT name FROM Teacher WHERE email=\"teacher1@naver.com\";")
    public String getTest();
}