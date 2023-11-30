package koreanmaster.board.dto;


import lombok.Getter;

@Getter
public class ReplyDTO {
    private final int replyId;
    private final String writer;
    private final String registrationDate;
    private final String content;

    public ReplyDTO(int replyId, String writer, String registrationDate, String content){
        this.replyId = replyId;
        this.writer = writer;
        this.registrationDate = registrationDate;
        this.content = content;
    }
}
