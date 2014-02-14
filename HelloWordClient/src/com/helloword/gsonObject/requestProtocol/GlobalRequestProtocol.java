package com.helloword.gsonObject.requestProtocol;

import com.helloword.gsonObject.GlobalProtocol;

public class GlobalRequestProtocol extends GlobalProtocol {
    
    private String sessionID = null;
    
    public String getSessionID() {
        return sessionID;
    }
    public void setSessionID(String string) {
        this.sessionID = string;
    }

}
