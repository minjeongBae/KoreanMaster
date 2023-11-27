package koreanmaster;

import koreanmaster.board.dao.BoardDAO;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        BoardDAO board = new BoardDAO();
        board.showMyBoard("ssii620@naver.com");
    }
}
