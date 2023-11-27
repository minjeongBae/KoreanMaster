package koreanmaster.board.dto;

import java.util.Date;

public class BoardDTO {
    private final int boardId;
    private final String title;
    private final String writer;
    private final Date registrationDate;
    private final String content;
    private final int replyId;

    public BoardDTO(int boardId, String title,
                    String writer, Date registrationDate,
                    String content, int replyId){
        this.boardId = boardId;
        this.title = title;
        this.writer = writer;
        this.registrationDate = registrationDate;
        this.content = content;
        this.replyId = replyId;
    }
}
