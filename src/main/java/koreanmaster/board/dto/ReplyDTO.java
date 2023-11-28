package koreanmaster.board.dto;

import java.util.Date;

public class ReplyDTO {
    private final int replyId;
    private final String writer;
    private final Date registrationDate;
    private final String content;

    public ReplyDTO(int replyId, String writer, Date registrationDate, String content){
        this.replyId = replyId;
        this.writer = writer;
        this.registrationDate = registrationDate;
        this.content = content;
    }
}
