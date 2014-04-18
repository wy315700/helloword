package com.helloword.gsonObject.user;

import com.helloword.gsonObject.UserFullInfo;

public class RegisterRequest extends GlobalRequest {
    private UserFullInfo userInfo;

    public UserFullInfo getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(UserFullInfo userInfo) {
        this.userInfo = userInfo;
    }
}