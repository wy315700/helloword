package com.helloword.gsonObject.responseProtocol.gameProtocol;

import com.helloword.gsonObject.GlobalGameDetails;

public class RankResponseProtocol extends GlobalGameResponseProtocol {
    
    GlobalGameDetails details = new GlobalGameDetails();
    
    public GlobalGameDetails getDetails() {
        return details;
    }
    public void setDetails(GlobalGameDetails details) {
        this.details = details;
    }
}
