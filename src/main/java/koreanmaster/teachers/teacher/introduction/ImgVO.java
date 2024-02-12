package koreanmaster.teachers.teacher.introduction;

import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Setter
@Entity(name="ImgVO")
public class ImgVO {
    @Id
    private int imgId;
    private String url;
}
