package com.helloword.gsonObject.user;

import com.helloword.gsonObject.GlobalProtocol;

public class GlobalRequest extends GlobalProtocol {
    private String sessionID;

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}
