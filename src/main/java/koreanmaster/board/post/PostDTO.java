package koreanmaster.board.post;

import lombok.Getter;
import lombok.Setter;

@Getter
public class PostDTO {
    private final int postId;
    private final String title;
    private final String writer;
    private final String registrationDate;
    @Setter
    private String content;
    @Setter
    private int replyId;

    public PostDTO(int boardId, String title,
                   String writer, String registrationDate,
                   String content, int replyId) {
        this.postId = boardId;
        this.title = title;
        this.writer = writer;
        this.registrationDate = registrationDate;
        this.content = content;
        this.replyId = replyId;
    }
}
