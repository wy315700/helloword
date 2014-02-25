package com.helloword.gsonObject.requestProtocol.gameProtocol;

public class PuzzlesRequestProtocol extends GlobalGameRequestProtocol {
    
    private String gameType = null;
    
    public String getGameType() {
        return gameType;
    }
    public void setGameType(String string) {
        this.gameType = string;
    }

}
