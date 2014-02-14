package com.helloword.protocolTransmission;

import com.google.gson.Gson;
import com.helloword.gsonObject.NewUserInfo;
import com.helloword.gsonObject.UserFullInfo;
import com.helloword.gsonObject.requestProtocol.ChangeUserInfoRequestProtocol;
import com.helloword.gsonObject.requestProtocol.LoginRequestProtocol;
import com.helloword.gsonObject.requestProtocol.LogoutRequestProtocol;
import com.helloword.gsonObject.requestProtocol.RegisterRequestProtocol;
import com.helloword.gsonObject.requestProtocol.UpdateTokenRequestProtocol;

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
        UserFullInfo loginInfo = new UserFullInfo();

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
        UserFullInfo logoutInfo = new UserFullInfo();
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
        UserFullInfo userInfo = new UserFullInfo();
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