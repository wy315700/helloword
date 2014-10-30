package com.helloword.service;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.util.Log;

import com.helloword.gsonObject.RankTotal;
import com.helloword.gsonObject.UserAnswer;
import com.helloword.gsonHelper.GameProtocol;
import com.helloword.gsonObject.game.PKAnswersResponse;
import com.helloword.gsonObject.game.PKPuzzlesResponse;
import com.helloword.gsonObject.game.RankResponse;
import com.helloword.util.HttpLinker;
import com.helloword.util.UsersApplication;

/**
 * @author Liletta game information transfer, like start a new game, download
 *         game content
 * 
 */
public class GameService {

    private UsersApplication user;
    private GameProtocol gameProtocol;
    private HttpLinker httpLinker;
    private List<RankTotal> rankTotal;

    public GameService(Application application) {
        user = (UsersApplication) application;
        gameProtocol = new GameProtocol();
        httpLinker = new HttpLinker();
        rankTotal = new ArrayList<RankTotal>();
    }

    public String getPKPuzzles(String gameType) {
        return getPKPuzzles(user.getSessionID(), gameType);
    }

    public String getPKPuzzles(String sessionID, String gameType) {
        String uploadString = gameProtocol
                .requestPKPuzzles(sessionID, gameType);
        String httpUrl = "http://halloword.sinaapp.com/helloword/request_pk_game.json";
        String downloadString = httpLinker.postString(httpUrl, uploadString);
       // Log.d(sessionID, "This is the Session");

        if (downloadString != null) {
            PKPuzzlesResponse pkPuzzlesResponse = gameProtocol
                    .responsePKPuzzles(downloadString);
            String result = pkPuzzlesResponse.getResult();
            Log.d("PK",downloadString);
            if (result.equals("success")) {
                user.setGameID(pkPuzzlesResponse.getDetails().getGameID());
                user.setPKPuzzles(pkPuzzlesResponse.getDetails().getGames());
            } else {
                result = pkPuzzlesResponse.getDetails().getError();
            }
            return result;
        }
        return "cannot receive data";
    }
    
    public String getRank(){
    	return getRank(user.getSessionID());
    }
    
    public String getRank(String sessionID){
    	String uploadString = gameProtocol.requestRank(sessionID);
    	String httpUrl = "http://halloword.sinaapp.com/helloword/request_rank.json";
    	String downloadString = httpLinker.postString(httpUrl, uploadString);
    	Log.d("session",sessionID);
    	
    	if(downloadString != null){
    		Log.d("Rank",downloadString);
    		RankResponse rankResponse = gameProtocol.responseRank(downloadString);
    		String result = rankResponse.getResult();
//    		Log.d("result:fisrt", result);
    		if(result.equals("success")){
//    			Log.d("result:", result);
    			user.setTotalScore(rankResponse.getDetails().getMyRank().gettotalScore());
    			user.setuserRank(rankResponse.getDetails().getMyRank().getuserRank());
//    			Log.d(user.getTotalScore(),user.getuserRank());
    			user.setRankTotal(rankResponse.getDetails().getTopRank());
    			
//    			Log.d("getMyRankTest_rank",rankResponse.getDetails().getMyRank().gettotalScore());
//    			Log.d("getMyRankTest_rank",rankResponse.getDetails().getMyRank().getuserRank());
//    			rankTotal = rankResponse.getDetails().getTopRank();
//    			Log.d(rankTotal.iterator().next().getuserNickname(),rankTotal.iterator().next().gettotalScore());
//    			Log.d(rankTotal.iterator().next().getuserNickname(),rankTotal.iterator().next().gettotalScore());
//    			Log.d("test",user.getRankTotal().iterator().next().gettotalScore());
//    			Log.d("test",user.getRankTotal().iterator().next().getuserNickname());
//    			Log.d("test",user.getRankTotal().iterator().next().getuserRank());
    		} else {
    			result = rankResponse.getDetails().getError();
    		}
    		return result;
    	}
    	return "cannot receive data";
    }
    
    public String getPKAnswers(String gameID, List<UserAnswer> userAnswer){
    	return getPKAnswers(user.getSessionID(), gameID, userAnswer);
    }
    
    public String getPKAnswers(String sessionID, String gameID, List<UserAnswer> userAnswer){
    	String uploadString = gameProtocol.requestPKAnswers(sessionID, gameID, userAnswer);
    	Log.d("uploadstringPK",uploadString);
    	String httpUrl = "http://halloword.sinaapp.com/helloword/upload_pk_result.json";
    	String downloadString = httpLinker.postString(httpUrl, uploadString);
    	
    	if(downloadString !=null){
    		Log.d("PKANS",downloadString);
    		PKAnswersResponse pkAnswersResponse = gameProtocol.ResponsePKAnswers(downloadString);
    		String result = pkAnswersResponse.getResult();
    		Log.d("uploadresult:", result);
    		if(result.equals("success")){
    			Log.d("result",result);
    		} else {
    			result = pkAnswersResponse.getDetails().getError();
    		}
    		return result;
    	}
    	return "cannot receive data";
    }
}
