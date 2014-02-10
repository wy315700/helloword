package com.helloword.gsonObject;

public class LogoutRequestProtocol extends GlobalProtocol {
    private UserInfo logoutInfo;
    
    public UserInfo getLogoutInfo() {
        return logoutInfo;
    }
    
    public void setLogoutInfo(UserInfo logoutInfo) {
        this.logoutInfo = logoutInfo;
    }
}