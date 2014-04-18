package com.helloword.gsonObject.user;

import com.helloword.gsonObject.UserInfo;

public class LoginRequest extends GlobalRequest {
    private UserInfo loginInfo;
    
    public UserInfo getLoginInfo() {
        return loginInfo;
    }
    
    public void setLoginInfo(UserInfo loginInfo) {
        this.loginInfo = loginInfo;
    }
}
