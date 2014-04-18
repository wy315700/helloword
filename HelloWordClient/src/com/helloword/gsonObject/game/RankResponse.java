package com.helloword.gsonObject.game;

import com.helloword.gsonObject.GlobalGameDetails;

public class RankResponse extends GlobalGameResponse {
    
    GlobalGameDetails details = new GlobalGameDetails();
    
    public GlobalGameDetails getDetails() {
        return details;
    }
    public void setDetails(GlobalGameDetails details) {
        this.details = details;
    }
}
