package com.helloword.protocolTransmission;

import com.google.gson.Gson;
import com.helloword.gsonObject.ChangeUserInfoRequestProtocol;
import com.helloword.gsonObject.LoginRequestProtocol;
import com.helloword.gsonObject.LogoutRequestProtocol;
import com.helloword.gsonObject.NewUserInfo;
import com.helloword.gsonObject.RegisterRequestProtocol;
import com.helloword.gsonObject.UpdateTokenRequestProtocol;
import com.helloword.gsonObject.UserInfo;

public class SerializeRequest {
    
    public String loginRequest(String userName, String password) {
       /*Serialize the login request as the following format:
        {
            "loginInfo" : {
                "userName" : "userName",
                "password" : "password"
            },
            "request" : "/user/login.json"
        }*/
    Gson gson = new Gson();
        LoginRequestProtocol requestData = new LoginRequestProtocol();
        UserInfo loginInfo = new UserInfo();

        loginInfo.setUserName(userName);
        loginInfo.setPassword(password);
        requestData.setRequest("/user/login.json");
        requestData.setLoginInfo(loginInfo);
        String requestJson = gson.toJson(requestData); 
        return requestJson;
    }
    
    public String logoutRequest(String sessionID, String userName) {
        /*Serialize the logout request as the following format:
        {
            "logoutInfo": {
                "userName" : "username"
            },
            "request" : "/user/logout.json",
            "sessionID" : "sessionID"
        }*/
        Gson gson = new Gson();
        UserInfo logoutInfo = new UserInfo();
        LogoutRequestProtocol requestData = new LogoutRequestProtocol();

        logoutInfo.setUserName(userName);
        requestData.setRequest("/user/logout.json");
        requestData.setSessionID(sessionID);
        requestData.setLogoutInfo(logoutInfo);

   	    String requestJson = gson.toJson(requestData);
   	    return requestJson;
    }

    public String registerRequest(String userName, String userNickname, String password) {
        /*Serialize the register request as the following format:
        {
            "userInfo" : {
                "userName" : "userName",
                "userNickname" : "userNickname",
                "password" : "password"
            },
            "request" : "/user/register.json"
        }*/
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setUserNickname(userNickname);
        userInfo.setPassword(password);

        RegisterRequestProtocol requestData = new RegisterRequestProtocol();
        requestData.setUserInfo(userInfo);
        requestData.setRequest("/user/register.json");

        Gson gson = new Gson();
        String requestJson = gson.toJson(requestData);
        return requestJson;
    }

    public String changeUserInfoRequest(String sessionID, String userName, String userNickname, String oldPassword, String newPassword) {
        /*Serialize the logout request as the following format:
        {
            "userInfo" : {
                "userName" : "userName",
                "userNickname" : "userNickname",
                "oldPassword" : "oldPassword"
                "newPassword" : "newPassword"
            },
            "request" : "/user/change_userinfo.json",
            "sessionID" : "sessionID"
        }*/
        NewUserInfo userInfo = new NewUserInfo();
        userInfo.setUserName(userName);
        userInfo.setUserNickname(userNickname);
        userInfo.setOldPassword(oldPassword);
        userInfo.setNewPassword(newPassword);

        ChangeUserInfoRequestProtocol requestData = new ChangeUserInfoRequestProtocol();
        requestData.setUserInfo(userInfo);
        requestData.setRequest("/user/change_userinfo.json");
        requestData.setSessionID(sessionID);

        Gson gson = new Gson();
        String requestJson = gson.toJson(requestData);
        return requestJson;
    }

    public String updateTokenRequest(String sessionID) {
        UpdateTokenRequestProtocol requestData = new UpdateTokenRequestProtocol();
        requestData.setRequest("/user/update_token.json");
        requestData.setSessionID(sessionID);

        Gson gson = new Gson();
        String requestJson = gson.toJson(requestData);
        return requestJson;
    }
}