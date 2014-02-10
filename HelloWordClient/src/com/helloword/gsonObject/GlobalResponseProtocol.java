package com.helloword.gsonObject;

public class GlobalResponseProtocol extends GlobalProtocol {
    private EmptyDetails details;

    public EmptyDetails getDetails() {
        return details;
    }
    public void setDetails(EmptyDetails details) {
        this.details = details;
    }

    class EmptyDetails {
        
    }
}