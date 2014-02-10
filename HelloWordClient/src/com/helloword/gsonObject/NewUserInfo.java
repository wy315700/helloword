package com.helloword.gsonObject;

public class NewUserInfo extends UserInfo {
    String oldPassword;
    String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }
    public void setOldPassword(String string) {
        this.oldPassword = string;
    }

    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String string) {
        this.newPassword = string;
    }
}