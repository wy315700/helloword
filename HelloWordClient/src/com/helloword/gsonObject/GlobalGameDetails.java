package com.helloword.gsonObject;

public class GlobalGameDetails extends GlobalDetails {
    String totalScore = null;
    String userRank = null;
    
    public String getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(String string) {
        this.totalScore = string;
    }
    
    public String getUserRank() {
        return userRank;
    }
    public void setUserRank(String string) {
        this.userRank = null;
    }
}
