package com.helloword.gsonObject.responseProtocol.gameProtocol;

import java.util.List;

import com.helloword.gsonObject.GlobalGameDetails;
import com.helloword.gsonObject.Puzzles;

public class PuzzlesResponseProtocol extends GlobalGameResponseProtocol {
    
    PuzzlesDetails details = new PuzzlesDetails();
    
    public PuzzlesDetails getDetails() {
        return details;
    }
    public void setDetails(PuzzlesDetails details) {
        this.details = details;
    }
    
    class PuzzlesDetails extends GlobalGameDetails {
        
        String num = null;
        List<Puzzles> games;
        
        public String getNum() {
            return num;
        }
        public void setNum(String string) {
            this.num = string;
        }
        
        public List<Puzzles> getGames() {
            return games;
        }
        
        public void setGames(List<Puzzles> games) {
            this.games = games;
        }
    }
}
