package com.helloword.util;

import java.util.List;

import android.app.Application;

import com.helloword.gsonObject.PKPuzzles;
import com.helloword.gsonObject.RankTotal;

public class UsersApplication extends Application {
    // store global variable of user's information to save IPC time
    private String sessionID;
    private String userName;
    private String userNickname;
    private String gameID;
    private List<PKPuzzles> pkPuzzles;
    private String userAvatarType;
    private String userAvatar;
    
    private String totalScore;
    private String totalRank;
    private String userRank;
    private List<Integer> myScore;
    private List<RankTotal> downRankTotal;
 
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
    
    public String getUserAvatarType() {
        return userAvatarType;
    }

    public void setUserAvatarType(String string) {
        this.userAvatarType = string;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String string) {
        this.userAvatar = string;
    }

    public List<PKPuzzles> getPKPuzzles() {
        return pkPuzzles;
    }

    public void setPKPuzzles(List<PKPuzzles> pkPuzzles) {
        this.pkPuzzles = pkPuzzles;
    }
    
    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String string) {
        this.totalScore = string;
    }
      
    public String getuserRank() {
        return userRank;
    }

    public void setuserRank(String string) {
        this.userRank = string;
    }
 
    
    public List<Integer> getMyScoreAll(){
    	return myScore;
    }
    
    
    public void setMyScoreAll(List<Integer> myscore){
    	this.myScore = myscore;
    }
    
    public List<RankTotal> getRankTotal(){
    	return downRankTotal;
    }
    
    public void setRankTotal(List<RankTotal> downRankTotal){
    	this.downRankTotal = downRankTotal;
    }
    
    
    @Override
    public void onCreate() { 
        super.onCreate(); 
        setSessionID("123456");
        setUserName("unKnown");
        setUserNickname("未登录");
        setGameID("54321");
        setUserAvatarType("id");
        setUserAvatar("1");
    }  

}
