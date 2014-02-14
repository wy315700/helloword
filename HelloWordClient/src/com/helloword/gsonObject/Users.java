package com.helloword.gsonObject;

public class Users {
    
    private String userName = null;
    private String password = null;
    private String userNickname = null;
    
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
}
