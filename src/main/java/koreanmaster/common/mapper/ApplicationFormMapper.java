package koreanmaster.common.mapper;

import koreanmaster.teachers.applicationform.ApplicationFormDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ApplicationFormMapper {
    @Insert("INSERT INTO Application_Form (form_code, frequency, time, level, state, counsel_time, addition) " +
            "VALUES (#{formCode}, #{form.frequency}, #{form.time}, #{form.level}, #{form.state}, #{form.counselTime}, #{form.addition})")
    void add(@Param("formCode") int formCode, @Param("form") ApplicationFormDTO form);

    @Select("SELECT * FROM Application_Form WHERE form_code = #{formCode}")
    ApplicationFormDTO getByCode(@Param("formCode") int formCode);
}
