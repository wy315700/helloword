package gsonObject;

public class RegisterRequestProtocol extends GlobalProtocol {
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}