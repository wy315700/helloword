package com.helloword.gsonObject.requestProtocol;

import com.helloword.gsonObject.UserFullInfo;

public class RegisterRequestProtocol extends GlobalRequestProtocol {
    private UserFullInfo userInfo;

    public UserFullInfo getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(UserFullInfo userInfo) {
        this.userInfo = userInfo;
    }
}