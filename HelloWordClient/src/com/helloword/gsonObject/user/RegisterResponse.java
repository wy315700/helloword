package com.helloword.gsonObject.user;

import com.helloword.gsonObject.GlobalUserDetails;

public class RegisterResponse extends GlobalResponse {
    
    private GlobalUserDetails details;

    public GlobalUserDetails getDetails() {
        return details;
    }

    public void setDetails(GlobalUserDetails details) {
        this.details = details;
    }

}