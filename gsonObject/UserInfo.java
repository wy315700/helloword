package gsonObject;

public class UserInfo {
    private String userID = null;
    private String userName = null;
    private String password = null;
    private String userNickname = null;
    private String userEmail = null;


    public String getUserID() {
        return userID;
    }
    public void setUserID(String string) {
        this.userID = string;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String string) {
        this.userName = string;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String string) {
        this.password = string;
    }

    public String getUserNickname() {
        return userNickname;
    }
    public void setUserNickname(String string) {
        this.userNickname = string;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String string) {
        this.userEmail = string;
    }
}