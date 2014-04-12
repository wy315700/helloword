package com.helloword.util;

import java.util.List;

import android.app.Application;

import com.helloword.gsonObject.PKPuzzles;

public class UsersApplication extends Application {
    // store global variable of user's information to save IPC time
    private String sessionID;
    private String userName;
    private String userNickname;
    private String gameID;
    private List<PKPuzzles> pkPuzzles;

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

    public List<PKPuzzles> getPKPuzzles() {
        return pkPuzzles;
    }

    public void setPKPuzzles(List<PKPuzzles> pkPuzzles) {
        this.pkPuzzles = pkPuzzles;
    }
    
    @Override
    public void onCreate() { 
        // TODO Auto-generated method stub 
        super.onCreate(); 
        setSessionID("123456");
        setUserName("Ling");
        setUserNickname("喵喵");
        setGameID("54321");
    }  

}
