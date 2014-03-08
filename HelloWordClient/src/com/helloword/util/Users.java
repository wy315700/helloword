package com.helloword.util;

import android.app.Application;

public class Users extends Application {
    // store global variable of user's information to save IPC time
    private String sessionID;
    private String userName;
    private String userNickname;
    private String gameID;

    public String getSessionID() {
        return sessionID;
    }
    public void setSessionID(String string) {
        this.sessionID = string;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String string) {
        this.userName = string;
    }

    public String getUserNickname() {
        return userNickname;
    }
    public void setUserNickname(String string) {
        this.userNickname = string;
    }

    public String getGameID() {
        return gameID;
    }
    public void setGameID(String string) {
        this.gameID = string;
    }
   
}
