package koreanmaster;

import koreanmaster.user.dao.UserDAO;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        UserDAO dao = new UserDAO();
        System.out.println(dao.checkCorrect("ssii620@naver.com","qoalswjd620!"));
    }
}

