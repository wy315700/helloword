package com.helloword.gsonObject.game;

import java.util.List;

import com.helloword.gsonObject.GlobalGameDetails;
import com.helloword.gsonObject.RankMe;
import com.helloword.gsonObject.RankTotal;

public class RankResponse extends GlobalGameResponse {
    
 /*   GlobalGameDetails details = new GlobalGameDetails();
  //  private GlobalGameDetails details;
    
    public GlobalGameDetails getDetails() {
        return details;
    }
    public void setDetails(GlobalGameDetails details) {
        this.details = details;
    }*/
    
    
     private RankGameDetails details;
     
     public RankGameDetails getDetails(){
         return details;
     }
     
     public void setDetails(RankGameDetails details){
     	this.details = details;
     }
     
     public class RankGameDetails extends GlobalGameDetails{
     	private List<RankTotal> topRank;
     	private RankMe myRank;
     	
     	public List<RankTotal> getTopRank(){
     		return topRank;
     	}
     	public void setTopRank(List<RankTotal> topRank){
     	    this.topRank = topRank;
     	}
     	
     	public RankMe getMyRank(){
     		return myRank;
     	}
     	public void setMyRank(RankMe myRank){
     		this.myRank = myRank;
     	}     
     }
     
    
}
