package koreanmaster.board.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManage {
    public String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
}
