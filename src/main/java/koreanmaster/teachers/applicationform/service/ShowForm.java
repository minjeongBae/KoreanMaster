package koreanmaster.teachers.applicationform.service;

import koreanmaster.common.mapper.ApplicationFormMapper;
import koreanmaster.common.mapper.SimpleFormMapper;
import koreanmaster.teachers.applicationform.SimpleFormDTO;
import lombok.Setter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowForm {
    @Setter(onMethod_ = @Autowired)
    private ApplicationFormMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private SimpleFormMapper simpleMapper;

    public List<SimpleFormDTO> getAllOfStudent(@Param("student") String student){
        return simpleMapper.getAllOfStudent(student);
    }

    public List<SimpleFormDTO> getAllOfTeacher(@Param("teacher") String teacher){
        return simpleMapper.getAllOfTeacher(teacher);
    }
}
