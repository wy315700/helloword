package com.helloword.gsonObject.responseProtocol;

import com.helloword.gsonObject.GlobalDetails;

public class UpdateTokenResponseProtocol extends GlobalResponseProtocol {
    
    private GlobalDetails details;

    public GlobalDetails getDetails() {
        return details;
    }

    public void setDetails(GlobalDetails details) {
        this.details = details;
    }

}