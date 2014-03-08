package com.helloword.unitTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.helloword.gsonObject.requestProtocol.gameProtocol.AnswersRequestProtocol;
import com.helloword.gsonObject.requestProtocol.gameProtocol.AnswersRequestProtocol.UserAnswer;
import com.helloword.gsonObject.requestProtocol.gameProtocol.PKAnswersRequestProtocol;
import com.helloword.protocolTransmission.SerializeGameRequest;

public class GameRequestGsonTest {
    
    @Test
    public void testAnswersRequest() {
        String sessionID = "12345678";
        String gameID = "87654321";
        String logout = "false";
        List<AnswersRequestProtocol.UserAnswer> userAnswer = new ArrayList<AnswersRequestProtocol.UserAnswer>();
        
        for (int i = 0; i < 40; i++) {
            AnswersRequestProtocol.UserAnswer userAns = new UserAnswer();
            userAns.setChosen("a");
            userAns.setTime("5");
            userAnswer.add(userAns);
        }
        
        SerializeGameRequest gameRequest = new SerializeGameRequest();
        String result = gameRequest.answersRequest(sessionID, gameID, logout, userAnswer);
        // System.out.println("answer " + result);
        String rightResult = "{\"userAnswer\":[{\"chosen\":\"a\",\"time\":\"5\"}";
        for (int i = 0; i < 39; i++) {
            rightResult += ",{\"chosen\":\"a\",\"time\":\"5\"}";
        }
        rightResult += "],";
        rightResult += "\"gameID\":\"87654321\",";
        rightResult += "\"logout\":\"false\",";
        rightResult += "\"sessionID\":\"12345678\",\"request\":\"/helloword/upload_result.json\"}";
        assertEquals(result, rightResult);
    }

    @Test
    public void testPuzzlesRequest() {
        String sessionID = "12345678";
        String gameType = "RPG";
        
        SerializeGameRequest gameRequest = new SerializeGameRequest();
        String result = gameRequest.puzzlesRequest(sessionID, gameType);
        // System.out.println("puzzels " + result);
        String rightResult = "{\"gameType\":\"RPG\",";
        rightResult += "\"sessionID\":\"12345678\",";
        rightResult += "\"request\":\"/helloword/request_game.json\"}";
        assertEquals(result, rightResult);
    }

    @Test
    public void testRankRequest() {
        String sessionID = "12345678";
        
        SerializeGameRequest gameRequest = new SerializeGameRequest();
        String result = gameRequest.rankRequest(sessionID);
        // System.out.println("rank " + result);
        String rightResult = "{\"sessionID\":\"12345678\",";
        rightResult += "\"request\":\"/helloword/request_rank.json\"}";
        assertEquals(result, rightResult);
    }

    @Test
    public void testDroppedOutRequest() {
        String sessionID = "12345678";
        String gameID = "87654321";
        String logout = "true";
        
        SerializeGameRequest gameRequest = new SerializeGameRequest();
        String result = gameRequest.droppedOutRequest(sessionID, gameID, logout);
        // System.out.println("droppedout" + result);
        String rightResult = "{\"gameID\":\"87654321\",";
        rightResult += "\"logout\":\"true\",";
        rightResult += "\"sessionID\":\"12345678\",";
        rightResult += "\"request\":\"/helloword/upload_result.json\"}";
        assertEquals(result, rightResult);
    }

    @Test
    public void testPKAnswersRequest() {
        String sessionID = "12345678";
        String gameID = "87654321";
        List<PKAnswersRequestProtocol.UserAnswer> userAnswer = new ArrayList<PKAnswersRequestProtocol.UserAnswer>();
        
        for (int i = 0; i < 40; i++) {
            AnswersRequestProtocol.UserAnswer userAns = new UserAnswer();
            userAns.setChosen("a");
            userAns.setTime("5");
            userAnswer.add(userAns);
        }
        
        SerializeGameRequest gameRequest = new SerializeGameRequest();
        String result = gameRequest.pkAnswersRequest(sessionID, gameID, userAnswer);
        // System.out.println("answer " + result);
        String rightResult = "{\"userAnswer\":[{\"chosen\":\"a\",\"time\":\"5\"}";
        for (int i = 0; i < 39; i++) {
            rightResult += ",{\"chosen\":\"a\",\"time\":\"5\"}";
        }
        rightResult += "],";
        rightResult += "\"gameID\":\"87654321\",";
        rightResult += "\"sessionID\":\"12345678\",\"request\":\"/helloword/upload_pk_result.json\"}";
        assertEquals(result, rightResult);
    }

    @Test
    public void tesPKtPuzzlesRequest() {
        String sessionID = "12345678";
        String gameType = "RPG";
        
        SerializeGameRequest gameRequest = new SerializeGameRequest();
        String result = gameRequest.pkPuzzlesRequest(sessionID, gameType);
        // System.out.println("puzzels " + result);
        String rightResult = "{\"gameType\":\"RPG\",";
        rightResult += "\"sessionID\":\"12345678\",";
        rightResult += "\"request\":\"/helloword/request_pk_game.json\"}";
        assertEquals(result, rightResult);
    }
}
