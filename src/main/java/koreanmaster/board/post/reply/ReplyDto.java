package koreanmaster.board.post.reply;

import lombok.Getter;

@Getter
public class ReplyDto {
    private final int replyId;
    private final String writer;
    private final String registrationDate;
    private String content;

    public ReplyDto(int replyId, String writer, String registrationDate, String content) {
        this.replyId = replyId;
        this.writer = writer;
        this.registrationDate = registrationDate;
        this.content = content;
    }

    public void setContent(String newContent) {
        this.content = newContent;
    }
}
