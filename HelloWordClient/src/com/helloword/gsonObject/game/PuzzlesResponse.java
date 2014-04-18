package com.helloword.gsonObject.game;

import java.util.List;

import com.helloword.gsonObject.GlobalGameDetails;

public class PuzzlesResponse extends GlobalGameResponse {

    PuzzlesDetails details = new PuzzlesDetails();

    public PuzzlesDetails getDetails() {
        return details;
    }
    public void setDetails(PuzzlesDetails details) {
        this.details = details;
    }

    public class PuzzlesDetails extends GlobalGameDetails {

        String num;
        String gameID;
        List<PuzzlesResponse> games;

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

        public List<PuzzlesResponse> getGames() {
            return games;
        }

        public void setGames(List<PuzzlesResponse> games) {
            this.games = games;
        }
    }
}
