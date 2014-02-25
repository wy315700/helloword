package com.helloword.unitTest;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import com.helloword.gsonObject.Puzzles;
import com.helloword.gsonObject.responseProtocol.gameProtocol.AnswersResponseProtocol;
import com.helloword.gsonObject.responseProtocol.gameProtocol.DroppedOutResponseProtocol;
import com.helloword.gsonObject.responseProtocol.gameProtocol.PuzzlesResponseProtocol;
import com.helloword.gsonObject.responseProtocol.gameProtocol.RankResponseProtocol;
import com.helloword.protocolTransmission.DeserializeGameResponse;

public class GameResponseGsonTest {

    @Test
    public void testAnswersResponse() {
        String jsonData = "{\"request\":\"/helloword/upload_result.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{";
        jsonData += "\"correct\":\"2\",";
        jsonData += "\"incorrect\":\"3\",";
        jsonData += "\"thisScore\":\"2\",";
        jsonData += "\"totalScore\":\"22\",";
        jsonData += "\"userRank\":\"23\"}}";
        
        DeserializeGameResponse response = new DeserializeGameResponse();
        AnswersResponseProtocol answersResponse = response.answersResponse(jsonData);
        
        assertEquals(answersResponse.getRequest(), "/helloword/upload_result.json");
        assertEquals(answersResponse.getResult(), "success"); 
        assertEquals(answersResponse.getDetails().getCorrect(), "2");
        assertEquals(answersResponse.getDetails().getIncorrect(), "3");
        assertEquals(answersResponse.getDetails().getThisScore(), "2");
        assertEquals(answersResponse.getDetails().getTotalScore(), "22");
        assertEquals(answersResponse.getDetails().getUserRank(), "23");
    }
 
    @Test
    public void testPuzzlesResponse() {
        String jsonData = "{\"request\":\"/helloword/request_game.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{";
        jsonData += "\"num\":\"10\",";
        jsonData += "\"gameID\":\"123456\",";
        jsonData += "\"games\":[";
        for (int i = 0; i < 40; i++) {
            jsonData += "{\"description\":\"i am a description\",";
            jsonData += "\"ans1\":\"a\",";
            jsonData += "\"ans2\":\"b\",";
            jsonData += "\"ans3\":\"c\",";
            jsonData += "\"ans4\":\"d\",";
            jsonData += "\"point\":\"5\",";
            jsonData += "\"time\":\"10\"}";
            if (i != 39) jsonData += ",";
        }
        jsonData += "]}}";

//        System.out.println(jsonData);
        
        DeserializeGameResponse response = new DeserializeGameResponse();
        PuzzlesResponseProtocol puzzlesResponse = response.puzzlesResponse(jsonData);
        assertEquals(puzzlesResponse.getRequest(), "/helloword/request_game.json");
        assertEquals(puzzlesResponse.getResult(), "success"); 
        assertEquals(puzzlesResponse.getDetails().getNum(), "10");
        assertEquals(puzzlesResponse.getDetails().getGameID(), "123456");

        Puzzles puzzle = new Puzzles();
        puzzle.setDescription("i am a description");
        puzzle.setAns1("a");
        puzzle.setAns2("b");
        puzzle.setAns3("c");
        puzzle.setAns4("d");
        puzzle.setPoint("5");
        puzzle.setTime("10");

        Iterator<Puzzles> iterator = puzzlesResponse.getDetails().getGames().iterator();
        while (iterator.hasNext()) {
            Puzzles puzzlesGet = iterator.next();
            assertEquals(puzzlesGet.getDescription(), puzzle.getDescription());
            assertEquals(puzzlesGet.getAns1(), puzzle.getAns1());
            assertEquals(puzzlesGet.getAns2(), puzzle.getAns2());
            assertEquals(puzzlesGet.getAns3(), puzzle.getAns3());
            assertEquals(puzzlesGet.getAns4(), puzzle.getAns4());
            assertEquals(puzzlesGet.getPoint(), puzzle.getPoint());
            assertEquals(puzzlesGet.getTime(), puzzle.getTime());
        }
    }

    @Test
    public void testRankResponse() {
        String jsonData = "{\"request\":\"/helloword/request_rank.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{";
        jsonData += "\"totalScore\":\"22\",";
        jsonData += "\"userRank\":\"23\"}}";
     
        DeserializeGameResponse response = new DeserializeGameResponse();
        RankResponseProtocol rankResponse = response.rankResponse(jsonData);
        assertEquals(rankResponse.getRequest(), "/helloword/request_rank.json");
        assertEquals(rankResponse.getResult(), "success");
        assertEquals(rankResponse.getDetails().getTotalScore(), "22"); 
        assertEquals(rankResponse.getDetails().getUserRank(), "23");
    }
    @Test
    public void testDroppedOutResponse() {
        String jsonData = "{\"request\":\"/helloword/user_logout.json\",";
        jsonData += "\"result\":\"success\"}";

        DeserializeGameResponse response = new DeserializeGameResponse();
        DroppedOutResponseProtocol droppedOutResponse = response.droppedOutResponse(jsonData);
        assertEquals(droppedOutResponse.getRequest(), "/helloword/user_logout.json");
        assertEquals(droppedOutResponse.getResult(), "success");
    }
} 
