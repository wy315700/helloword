package com.helloword.gsonObject.user;

import com.helloword.gsonObject.UserInfo;

public class LogoutRequest extends GlobalRequest {
    private UserInfo logoutInfo;
    
    public UserInfo getLogoutInfo() {
        return logoutInfo;
    }
    
    public void setLogoutInfo(UserInfo logoutInfo) {
        this.logoutInfo = logoutInfo;
    }
}