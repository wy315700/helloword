package com.helloword.protocolTransmission;

import java.util.List;

import com.google.gson.Gson;
import com.helloword.gsonObject.UserAnswer;
import com.helloword.gsonObject.requestProtocol.gameProtocol.AnswersRequestProtocol;

public class SerializeGameRequest {

    public String answersRequest(String request, String sessionID, 
            String gameID, String logout, List<UserAnswer> userAnswer) {
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
}
