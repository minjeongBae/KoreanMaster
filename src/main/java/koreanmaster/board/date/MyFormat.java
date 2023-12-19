package koreanmaster.board.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFormat {
    public String get(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
}
