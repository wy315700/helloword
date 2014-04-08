package com.helloword.service;

import android.app.Application;
import android.util.Log;

import com.helloword.gsonObject.responseProtocol.gameProtocol.PKPuzzlesResponseProtocol;
import com.helloword.protocolTransmission.DeserializeGameResponse;
import com.helloword.protocolTransmission.SerializeGameRequest;
import com.helloword.util.HttpLinker;
import com.helloword.util.UsersApplication;

/**
 * @author Liletta game information transfer, like start a new game, download
 *         game content
 * 
 */
public class GameService {

    private UsersApplication user;

    public GameService(Application application) {
        user = (UsersApplication) application;
    }

    public String getPKPuzzles(String gameType) {
        return getPKPuzzles(user.getSessionID(), gameType);
    }

    public String getPKPuzzles(String sessionID, String gameType) {
        SerializeGameRequest gameRequest = new SerializeGameRequest();
        String stringUpload = gameRequest.pkPuzzlesRequest(sessionID, gameType);
        String httpUrl = "http://halloword.sinaapp.com/helloword/request_pk_game.json";
        HttpLinker httpLinker = new HttpLinker();
        String stringDownload = httpLinker.stringPost(httpUrl, stringUpload);
        Log.d("pkgame", stringDownload);
        
        DeserializeGameResponse gameResponse = new DeserializeGameResponse();
        if (stringDownload != null) {
            PKPuzzlesResponseProtocol pkPuzzlesResponse = gameResponse
                    .pkPuzzlesResponse(stringDownload);
            String result = pkPuzzlesResponse.getResult();
            if (result.equals("success")) {
                user.setGameID(pkPuzzlesResponse.getDetails().getGameID());
                user.setPKPuzzles(pkPuzzlesResponse.getDetails().getGames());
            }
            else {
                result = pkPuzzlesResponse.getDetails().getError();
            }
            return result;
        }
        return "cannot receive data";
    }
}
