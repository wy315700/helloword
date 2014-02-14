package com.helloword.unitTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.helloword.gsonObject.UserAnswer;
import com.helloword.protocolTransmission.SerializeGameRequest;

public class GameRequestGsonTest {
    
    @Test
    public void testAnswersRequest() {
        String request = "/helloword/upload_result.json";
        String sessionID = "12345678";
        String gameID = "87654321";
        String logout = "false";
        List<UserAnswer> userAnswer = new ArrayList<UserAnswer>();
        
        for (int i = 0; i < 40; i++) {
            UserAnswer userAns = new UserAnswer();
            userAns.setChosen("a");
            userAns.setTime("5");
            userAnswer.add(userAns);
        }
        
        SerializeGameRequest gameRequest = new SerializeGameRequest();
        String result = gameRequest.answersRequest(request, sessionID, gameID, logout, userAnswer);
        System.out.println(result);
        
    }

}
