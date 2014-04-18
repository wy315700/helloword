package com.helloword.gsonObject.user;

import com.helloword.gsonObject.UserInfo;

public class ChangeUserInfoRequest extends GlobalRequest {
    private NewUserInfo userInfo;

    public NewUserInfo getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(NewUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public static class NewUserInfo extends UserInfo {
        String oldPassword;
        String newPassword;

        public String getOldPassword() {
            return oldPassword;
        }
        public void setOldPassword(String oldPassword) {
            this.oldPassword = oldPassword;
        }

        public String getNewPassword() {
            return newPassword;
        }
        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }
}