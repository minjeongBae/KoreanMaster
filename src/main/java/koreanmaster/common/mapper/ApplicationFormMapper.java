package koreanmaster.common.mapper;

import koreanmaster.teachers.applicationform.ApplicationFormDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ApplicationFormMapper {
    @Insert("INSERT INTO Application_Form (form_code, frequency, time, level, root, state, counsel_time, addition) " +
            "VALUES (#{formCode}, #{form.frequency}, #{form.time}, #{form.level}, #{form.root}, " +
            "#{form.state}, #{form.counselTime}, #{form.addition})")
    void add(@Param("formCode") int formCode, @Param("form") ApplicationFormDTO form);

    @Select("SELECT * FROM Application_Form WHERE form_code = #{formCode}")
    ApplicationFormDTO getByCode(@Param("formCode") int formCode);

    @Delete("DELETE FROM Application_Form WHERE form_code = #{formCode}")
    void remove(int formCode);
}
