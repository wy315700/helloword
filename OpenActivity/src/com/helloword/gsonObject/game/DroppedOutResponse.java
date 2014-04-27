package com.helloword.gsonObject.game;

import com.helloword.gsonObject.GlobalGameDetails;

public class DroppedOutResponse extends GlobalGameResponse {

    GlobalGameDetails details = new GlobalGameDetails();
    
    public GlobalGameDetails getDetails() {
        return details;
    }
    public void setDetails(GlobalGameDetails details) {
        this.details = details;
    }
}
