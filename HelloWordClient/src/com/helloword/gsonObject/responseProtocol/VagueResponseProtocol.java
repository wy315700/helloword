package com.helloword.gsonObject.responseProtocol;

public class VagueResponseProtocol extends GlobalResponseProtocol {
    
    private Details details;

    public Details getDetails() {
        return details;
    }
    public void setDetails(Details details) {
        this.details = details;
    }

    private class Details {
        
    }
}
