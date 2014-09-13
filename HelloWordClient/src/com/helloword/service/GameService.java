package com.helloword.service;

import android.app.Application;
import android.util.Log;

import com.helloword.gsonHelper.GameProtocol;
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

    public GameService(Application application) {
        user = (UsersApplication) application;
        gameProtocol = new GameProtocol();
        httpLinker = new HttpLinker();
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
    	//System.out.println("test: " + downloadString);
    	Log.d("This is the Session", sessionID);
    	Log.d("This is the downString", downloadString);

    	
    	if(downloadString != null){
    		RankResponse rankResponse = gameProtocol.responseRank(downloadString);
    		String result = rankResponse.getResult();
    		Log.d("result:fisrt", result);
    		if(result.equals("success")){
    			Log.d("result:", result);
    			user.setTotalScore(rankResponse.getDetails().getTotalScore());
    			user.setuserRank(rankResponse.getDetails().getUserRank());
    			Log.d("totalScore", user.getTotalScore());
    			Log.d("userRank", user.getuserRank());
    	//		System.out.println("score: "+rankResponse.getDetails().getTotalScore());
    	//		System.out.println("Rank: "+rankResponse.getDetails().getUserRank());
    		} else {
    			result = rankResponse.getDetails().getError();
    		}
    		return result;
    	}
    	return "cannot receive data";
    }
}
