package koreanmaster.student.dto;

import java.util.Date;

public class StudentDTO {
    private final String email;
    private final String password;
    private final String name;
    private final Date birth;
    private final int level;

    public StudentDTO(String e, String p, String n, Date b, int l){
        this.email = e;
        this.password = p;
        this.name = n;
        this.birth = b;
        this.level = l;
    }
}
