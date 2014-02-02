package gsonObject;

public class ChangeUserInfoRequestProtocol extends GlobalProtocol {
    private NewUserInfo userInfo;

    public NewUserInfo getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(NewUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}