package com.helloword.gsonObject.requestProtocol;

import com.helloword.gsonObject.UserInfo;

public class LogoutRequestProtocol extends GlobalRequestProtocol {
    private UserInfo logoutInfo;
    
    public UserInfo getLogoutInfo() {
        return logoutInfo;
    }
    
    public void setLogoutInfo(UserInfo logoutInfo) {
        this.logoutInfo = logoutInfo;
    }
}