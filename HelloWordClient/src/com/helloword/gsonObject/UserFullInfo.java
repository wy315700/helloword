package com.helloword.gsonObject;

public class UserFullInfo extends UserInfo {
    private String userID = null;
    private String userEmail = null;

    public String getUserID() {
        return userID;
    }
    public void setUserID(String string) {
        this.userID = string;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String string) {
        this.userEmail = string;
    }
}