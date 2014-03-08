package com.helloword.gsonObject.responseProtocol.gameProtocol;

import java.util.List;

import com.helloword.gsonObject.GlobalGameDetails;
import com.helloword.gsonObject.PKPuzzles;

public class PKPuzzlesResponseProtocol extends GlobalGameResponseProtocol {
    
PKPuzzlesDetails details = new PKPuzzlesDetails();
    
    public PKPuzzlesDetails getDetails() {
        return details;
    }
    public void setDetails(PKPuzzlesDetails details) {
        this.details = details;
    }
    
    public class PKPuzzlesDetails extends GlobalGameDetails {
        
        String num = null;
        String gameID = null;
        List<PKPuzzles> games;
        
        public String getNum() {
            return num;
        }
        public void setNum(String string) {
            this.num = string;
        }
        
        public String getGameID() {
            return gameID;
        }
        public void setGameID(String string) {
            this.gameID = string;
        }
        
        public List<PKPuzzles> getGames() {
            return games;
        }
        
        public void setGames(List<PKPuzzles> games) {
            this.games = games;
        }
    }
}
