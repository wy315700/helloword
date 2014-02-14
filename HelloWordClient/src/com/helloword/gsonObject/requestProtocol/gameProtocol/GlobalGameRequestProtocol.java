package com.helloword.gsonObject.requestProtocol.gameProtocol;

import com.helloword.gsonObject.requestProtocol.GlobalRequestProtocol;

public class GlobalGameRequestProtocol extends GlobalRequestProtocol {
    
    private String gameID = null;
    private String logout = null;
    
    public String getGameID() {
        return gameID;
    }
    public void setGameID(String string) {
        this.gameID = string;
    }
    
    public String getLogout() {
        return logout;
    }
    public void setLogout(String string) {
        this.logout = string;
    }
    
}
