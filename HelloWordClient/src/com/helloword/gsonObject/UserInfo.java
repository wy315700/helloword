package com.helloword.gsonObject;

public class UserInfo {
    
    private String userName = null;
    private String password = null;
    private String userNickname = null;
    private String userAvatarType = null;
    private String userAvatar = null;
    
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
    
    public String getUserAvatarType() {
        return userAvatarType;
    }
    public void setUserAvatarType(String string) {
        this.userAvatarType = string;
    }

    public String getUserAvatar() {
        return userAvatar;
    }
    public void setUserAvatar(String string) {
        this.userAvatar = string;
    }
    
}
