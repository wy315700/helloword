package com.helloword.gsonObject.user;

public class VagueResponse extends GlobalResponse {
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
