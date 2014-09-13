package com.helloword.gsonObject.game;

import com.helloword.gsonObject.GlobalGameDetails;

public class RankResponse extends GlobalGameResponse {
    
    GlobalGameDetails details = new GlobalGameDetails();
  //  private GlobalGameDetails details;
    
    public GlobalGameDetails getDetails() {
        return details;
    }
    public void setDetails(GlobalGameDetails details) {
        this.details = details;
    }
    
    /*
     private RankGameDetails details;
     
     public RankGameDetails getDetails(){
         return details;
     }
     
     public void setDetails(RankGameDetails details){
     	this.details = details;
     }
     
     public class RankGameDetails{
     	private List<RankTotal> topRank;
     	private RankMe myRank;
     	
     	public List<RankTotal> getTopRank(){
     		return topRank;
     	}
     	public void setTopRank(List<RankTotal>){
     	    this.topRank = topRank;
     	}
     	
     	public RankMe getMyRank(){
     		return myRank;
     	}
     	public void setMyRank(RankMe myRank){
     		this.myRank = myRank;
     	}     
     }
     */
    
}
