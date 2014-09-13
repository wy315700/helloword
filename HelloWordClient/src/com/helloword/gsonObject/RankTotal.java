package com.helloword.gsonObject;

//by zhf

public class RankTotal{
	private String userNickname;
	private String totalScore;
	private String userRank;	
	
	public String getuserNickname() {
        return userNickname;
    }
    public void setuserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    
    public String gettotalScore() {
        return totalScore;
    }
    public void settotalScore(String totalScore) {
        this.totalScore = totalScore;
    }
    
    public String getuserRank() {
        return userRank;
    }
    public void setuserRank(String userRank) {
        this.userRank = userRank;
    }
}