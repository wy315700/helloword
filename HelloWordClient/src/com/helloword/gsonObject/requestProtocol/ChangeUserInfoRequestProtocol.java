package com.helloword.gsonObject.requestProtocol;

import com.helloword.gsonObject.NewUserInfo;

public class ChangeUserInfoRequestProtocol extends GlobalRequestProtocol {
    private NewUserInfo userInfo;

    public NewUserInfo getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(NewUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}