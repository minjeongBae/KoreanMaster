package koreanmaster.mypage.service;

import koreanmaster.home.user.dao.Select;
import koreanmaster.home.user.UserDTO;

import java.sql.SQLException;

public class SignIn {
    private UserDTO user;
    public boolean isSuccess(String email, String pw) throws SQLException {
        Select selectTool = new Select();
        this.user = selectTool.checkUser(email, pw);
        if(this.user==null) return false;
        System.out.println("로그인 성공");
        return true;
    }

    public UserDTO getUser(){
        return this.user;
    }
}
