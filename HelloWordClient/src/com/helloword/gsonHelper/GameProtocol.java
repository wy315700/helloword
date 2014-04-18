package com.helloword.gsonHelper;

import java.util.List;

import com.google.gson.Gson;
import com.helloword.gsonObject.UserAnswer;
import com.helloword.gsonObject.game.AnswersRequest;
import com.helloword.gsonObject.game.AnswersResponse;
import com.helloword.gsonObject.game.DroppedOutRequest;
import com.helloword.gsonObject.game.DroppedOutResponse;
import com.helloword.gsonObject.game.PKAnswersRequest;
import com.helloword.gsonObject.game.PKAnswersResponse;
import com.helloword.gsonObject.game.PKPuzzlesRequest;
import com.helloword.gsonObject.game.PKPuzzlesResponse;
import com.helloword.gsonObject.game.PuzzlesRequest;
import com.helloword.gsonObject.game.PuzzlesResponse;
import com.helloword.gsonObject.game.RankRequest;
import com.helloword.gsonObject.game.RankResponse;

public class GameProtocol {
    private Gson gson;

    public GameProtocol() {
        gson = new Gson();
    }

    public String requestAnswers(String sessionID,
                                 String gameID, String logout, List<UserAnswer> userAnswer) {
        AnswersRequest answersRequest = new AnswersRequest();
        answersRequest.setRequest("/helloword/upload_result.json");
        answersRequest.setSessionID(sessionID);
        answersRequest.setGameID(gameID);
        answersRequest.setLogout(logout);
        answersRequest.setUserAnswer(userAnswer);

        String answersJson = gson.toJson(answersRequest);
        return answersJson;
    }

    public AnswersResponse responseAnswers(String jsonGet) {
        AnswersResponse answersResponse = new AnswersResponse();
        answersResponse = gson.fromJson(jsonGet, AnswersResponse.class);
        return answersResponse;
    }

    public String requestPuzzles(String sessionID, String gameType) {
        PuzzlesRequest puzzlesRequest = new PuzzlesRequest();
        puzzlesRequest.setRequest("/helloword/request_game.json");
        puzzlesRequest.setSessionID(sessionID);
        puzzlesRequest.setGameType(gameType);

        String puzzlesJson = gson.toJson(puzzlesRequest);
        return puzzlesJson;
    }

    public  PuzzlesResponse responsePuzzles(String jsonGet) {
        PuzzlesResponse puzzlesResponse = new PuzzlesResponse();
        puzzlesResponse = gson.fromJson(jsonGet, PuzzlesResponse.class);
        return puzzlesResponse;
    }

    public String requestRank(String sessionID) {
        RankRequest rankRequest = new RankRequest();
        rankRequest.setRequest("/helloword/request_rank.json");
        rankRequest.setSessionID(sessionID);

        String rankJson = gson.toJson(rankRequest);
        return rankJson;
    }

    public RankResponse responseRank(String jsonGet) {
        RankResponse rankResponse = new RankResponse();
        rankResponse = gson.fromJson(jsonGet, RankResponse.class);
        return rankResponse;
    }

    public String requestDroppedOut(String sessionID, String gameID, String logout) {
        DroppedOutRequest droppedOutRequest = new DroppedOutRequest();
        droppedOutRequest.setRequest("/helloword/upload_result.json");
        droppedOutRequest.setSessionID(sessionID);
        droppedOutRequest.setGameID(gameID);
        droppedOutRequest.setLogout(logout);

        String droppedOutJson = gson.toJson(droppedOutRequest);
        return droppedOutJson;
    }

    public DroppedOutResponse responseDroppedOut(String jsonGet) {
        DroppedOutResponse droppedOutResponse = new DroppedOutResponse();
        droppedOutResponse = gson.fromJson(jsonGet, DroppedOutResponse.class);
        return droppedOutResponse;
    }

    public String requestPKPuzzles(String sessionID, String gameType) {
        PKPuzzlesRequest pkPuzzlesRequest = new PKPuzzlesRequest();
        pkPuzzlesRequest.setRequest("/helloword/request_pk_game.json");
        pkPuzzlesRequest.setSessionID(sessionID);
        pkPuzzlesRequest.setGameType(gameType);

        String pkPuzzlesJson = gson.toJson(pkPuzzlesRequest);
        return pkPuzzlesJson;
    }

    public  PKPuzzlesResponse responsePKPuzzles(String jsonGet) {
        PKPuzzlesResponse pkPuzzlesResponse = new PKPuzzlesResponse();
        pkPuzzlesResponse = gson.fromJson(jsonGet, PKPuzzlesResponse.class);
        return pkPuzzlesResponse;
    }

    public String requestPKAnswers(String sessionID, String gameID,
                                   List<UserAnswer> userAnswer) {
        PKAnswersRequest pkAnswersRequest = new PKAnswersRequest();
        pkAnswersRequest.setRequest("/helloword/upload_pk_result.json");
        pkAnswersRequest.setSessionID(sessionID);
        pkAnswersRequest.setGameID(gameID);
        pkAnswersRequest.setUserAnswer(userAnswer);

        String pkAnswersJson = gson.toJson(pkAnswersRequest);
        return pkAnswersJson;
    }


    public PKAnswersResponse ResponsePKAnswers(String jsonGet) {
        PKAnswersResponse pkAnswersResponse = new PKAnswersResponse();
        pkAnswersResponse = gson.fromJson(jsonGet, PKAnswersResponse.class);
        return pkAnswersResponse;
    }










}
