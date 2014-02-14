package com.helloword.gsonObject.requestProtocol;

import com.helloword.gsonObject.Users;

public class LoginRequestProtocol extends GlobalRequestProtocol {
    private Users loginInfo;
    
    public Users getLoginInfo() {
        return loginInfo;
    }
    
    public void setLoginInfo(Users loginInfo) {
        this.loginInfo = loginInfo;
    }
}
