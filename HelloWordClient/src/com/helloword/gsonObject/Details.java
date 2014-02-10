package com.helloword.gsonObject;

public class Details {
    String sessionID;
    String errorCode;
    String error;
    UserInfo userInfo;

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String string) {
        this.sessionID = string;
    }
    
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String string) {
        this.errorCode = string;
    }
    
    public String getError() {
        return error;
    }

    public void setError(String string) {
        this.error = string;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
}
