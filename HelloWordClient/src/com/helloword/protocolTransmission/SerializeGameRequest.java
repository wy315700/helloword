package com.helloword.protocolTransmission;

import java.util.List;

import com.google.gson.Gson;
import com.helloword.gsonObject.requestProtocol.gameProtocol.AnswersRequestProtocol;
import com.helloword.gsonObject.requestProtocol.gameProtocol.DroppedOutRequestProtocol;
import com.helloword.gsonObject.requestProtocol.gameProtocol.PuzzlesRequestProtocol;
import com.helloword.gsonObject.requestProtocol.gameProtocol.RankRequestProtocol;

public class SerializeGameRequest {

    public String answersRequest(String sessionID, 
            String gameID, String logout, List<AnswersRequestProtocol.UserAnswer> userAnswer) {
        String request = "/helloword/upload_result.json";
        AnswersRequestProtocol answersRequest = new AnswersRequestProtocol();
        
        answersRequest.setRequest(request);
        answersRequest.setSessionID(sessionID);
        answersRequest.setGameID(gameID);
        answersRequest.setLogout(logout);
        answersRequest.setUserAnswer(userAnswer);
        
        Gson gson = new Gson();
        String jsonData = gson.toJson(answersRequest);
        return jsonData;
    }
    
    public String puzzlesRequest(String sessionID, String gameType) {
        String request = "/helloword/request_game.json";
        PuzzlesRequestProtocol puzzlesRequest = new PuzzlesRequestProtocol();
        
        puzzlesRequest.setRequest(request);
        puzzlesRequest.setSessionID(sessionID);
        puzzlesRequest.setGameType(gameType);
        
        Gson gson = new Gson();
        String jsonData = gson.toJson(puzzlesRequest);
        return jsonData;
    }
    
    public String rankRequest(String sessionID) {
        String request = "/helloword/request_rank.json";
        RankRequestProtocol rankRequest = new RankRequestProtocol();
        
        rankRequest.setRequest(request);
        rankRequest.setSessionID(sessionID);
        
        Gson gson = new Gson();
        String jsonData = gson.toJson(rankRequest);
        return jsonData;
    }
    
    public String droppedOutRequest(String sessionID, String gameID, String logout) {
        String request = "/helloword/upload_result.json";
        DroppedOutRequestProtocol droppedOutRequest = new DroppedOutRequestProtocol();
        
        droppedOutRequest.setRequest(request);
        droppedOutRequest.setSessionID(sessionID);
        droppedOutRequest.setGameID(gameID);
        droppedOutRequest.setLogout(logout);
        
        Gson gson = new Gson();
        String jsonData = gson.toJson(droppedOutRequest);
        return jsonData;
    }
}
