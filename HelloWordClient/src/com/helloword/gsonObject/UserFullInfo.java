package com.helloword.gsonObject;

public class UserFullInfo extends UserInfo {
    private String userID;
    private String userEmail;

    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}