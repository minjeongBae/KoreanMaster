package koreanmaster.board.post.reply;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDTO {
    private int replyId;
    private String writer;
    private String registrationDate;
    private String content;

    public ReplyDTO(int replyId, String writer, String registrationDate, String content) {
        this.replyId = replyId;
        this.writer = writer;
        this.registrationDate = registrationDate;
        this.content = content;
    }
}
