package com.helloword.gsonObject.requestProtocol;

import com.helloword.gsonObject.UserInfo;

public class ChangeUserInfoRequestProtocol extends GlobalRequestProtocol {
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
}