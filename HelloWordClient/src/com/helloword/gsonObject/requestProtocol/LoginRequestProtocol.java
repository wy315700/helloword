package com.helloword.gsonObject.requestProtocol;

import com.helloword.gsonObject.UserInfo;

public class LoginRequestProtocol extends GlobalRequestProtocol {
    private UserInfo loginInfo;
    
    public UserInfo getLoginInfo() {
        return loginInfo;
    }
    
    public void setLoginInfo(UserInfo loginInfo) {
        this.loginInfo = loginInfo;
    }
}
