package com.helloword.gsonObject.requestProtocol;

import com.helloword.gsonObject.Users;

public class LogoutRequestProtocol extends GlobalRequestProtocol {
    private Users logoutInfo;
    
    public Users getLogoutInfo() {
        return logoutInfo;
    }
    
    public void setLogoutInfo(Users logoutInfo) {
        this.logoutInfo = logoutInfo;
    }
}