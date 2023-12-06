package koreanmaster.user.service;

import koreanmaster.user.dao.UserDAO;
import koreanmaster.user.dto.UserDTO;

import java.sql.SQLException;

public class SignIn {
    private UserDTO user;
    public boolean isSuccess(String email, String pw) throws SQLException {
        UserDAO dao = new UserDAO();
        this.user = dao.checkCorrect(email, pw);
        if(this.user==null) return false;
        System.out.println("로그인 성공");
        return true;
    }

    public UserDTO getUser(){
        return this.user;
    }
}
