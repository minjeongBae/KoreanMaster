package koreanmaster.board.post;

import lombok.Getter;

@Getter
public class PostDTO {
    private final int postId;
    private final String title;
    private final String writer;
    private final String registrationDate;
    private String content;
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

    public void setContent(String newContent) {
        this.content = newContent;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }
}
