package com.helloword.service;

import android.app.Application;

import com.helloword.gsonHelper.GameProtocol;
import com.helloword.gsonObject.game.PKPuzzlesResponse;
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
        // Log.d("pkgame", stringDownload);

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
}
