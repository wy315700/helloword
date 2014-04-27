package com.helloword.gsonObject.game;

import java.util.List;

import com.helloword.gsonObject.GlobalGameDetails;
import com.helloword.gsonObject.PKPuzzles;

public class PKPuzzlesResponse extends GlobalGameResponse {
    
PKPuzzlesDetails details = new PKPuzzlesDetails();
    
    public PKPuzzlesDetails getDetails() {
        return details;
    }
    public void setDetails(PKPuzzlesDetails details) {
        this.details = details;
    }
    
    public class PKPuzzlesDetails extends GlobalGameDetails {
        
        String num;
        String gameID;
        List<PKPuzzles> games;
        
        public String getNum() {
            return num;
        }
        public void setNum(String num) {
            this.num = num;
        }
        
        public String getGameID() {
            return gameID;
        }
        public void setGameID(String gameID) {
            this.gameID = gameID;
        }
        
        public List<PKPuzzles> getGames() {
            return games;
        }
        
        public void setGames(List<PKPuzzles> games) {
            this.games = games;
        }
    }
}
