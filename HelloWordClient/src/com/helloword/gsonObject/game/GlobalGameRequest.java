package com.helloword.gsonObject.game;

import com.helloword.gsonObject.user.GlobalRequest;

public class GlobalGameRequest extends GlobalRequest {
    private String gameID;
    private String logout;
    
    public String getGameID() {
        return gameID;
    }
    public void setGameID(String gameID) {
        this.gameID = gameID;
    }
    
    public String getLogout() {
        return logout;
    }
    public void setLogout(String logout) {
        this.logout = logout;
    }
}
