package gsonObject;

public class LoginRequestProtocol extends GlobalProtocol {
    private UserInfo loginInfo;
    
    public UserInfo getLoginInfo() {
        return loginInfo;
    }
    
    public void setLoginInfo(UserInfo loginInfo) {
        this.loginInfo = loginInfo;
    }
}
