package com.helloword.gsonObject.user;

import com.helloword.gsonObject.GlobalUserDetails;

public class ChangeUserInfoResponse extends GlobalResponse {
    
    private GlobalUserDetails details;

    public GlobalUserDetails getDetails() {
        return details;
    }

    public void setDetails(GlobalUserDetails details) {
        this.details = details;
    }

}