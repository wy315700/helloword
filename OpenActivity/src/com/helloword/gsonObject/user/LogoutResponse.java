package com.helloword.gsonObject.user;

import com.helloword.gsonObject.GlobalUserDetails;

public class LogoutResponse extends GlobalResponse {
    private GlobalUserDetails details;

    public GlobalUserDetails getDetails() {
        return details;
    }

    public void setDetails(GlobalUserDetails details) {
        this.details = details;
    }

}