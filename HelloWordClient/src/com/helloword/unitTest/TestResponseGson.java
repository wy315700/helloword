package com.helloword.unitTest;

import junit.framework.TestCase;

import com.helloword.gsonObject.ChangeUserInfoResponseProtocol;
import com.helloword.gsonObject.LoginResponseProtocol;
import com.helloword.gsonObject.LogoutResponseProtocol;
import com.helloword.gsonObject.RegisterResponseProtocol;
import com.helloword.gsonObject.UpdateTokenResponseProtocol;
import com.helloword.protocolTransmission.DeserializeResponse;

public class TestResponseGson extends TestCase {

    public void testLoginResponse() {
        DeserializeResponse response = new DeserializeResponse();
        String jsonData = "{\"request\":\"/user/login.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{\"userInfo\":{\"userID\":\"userID\",\"userName\":\"userName\",";
        jsonData += "\"userNickname\":\"userNickname\",\"userEmail\":\"userEmail\"},\"sessionID\":\"111aaa111\"}}";

        LoginResponseProtocol loginResponse = response.loginResponse(jsonData);
        assertEquals(loginResponse.getRequest(), "/user/login.json");
        assertEquals(loginResponse.getResult(), "success");
        assertEquals(loginResponse.getDetails().getUserInfo().getUserID(), "userID");
        assertEquals(loginResponse.getDetails().getUserInfo().getUserName(), "userName");
        assertEquals(loginResponse.getDetails().getUserInfo().getUserNickname(), "userNickname");
        assertEquals(loginResponse.getDetails().getUserInfo().getUserEmail(), "userEmail");
        assertEquals(loginResponse.getDetails().getSessionID(), "111aaa111");
    }    
    public void testLogoutResponse() {
        DeserializeResponse response = new DeserializeResponse();
        String jsonData = "{\"request\":\"/user/logout.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{}}";

        LogoutResponseProtocol logoutResponse = response.logoutResponse(jsonData);
        assertEquals(logoutResponse.getRequest(), "/user/logout.json");
        assertEquals(logoutResponse.getResult(), "success");
    }

    public void testRegisterResponse() {
        DeserializeResponse response = new DeserializeResponse();
        String jsonData = "{\"request\":\"/user/register.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{\"userInfo\":{\"userID\":\"userID\",\"userName\":\"userName\",";
        jsonData += "\"userNickname\":\"userNickname\",\"userEmail\":\"userEmail\"},\"sessionID\":\"111aaa111\"}}";

        RegisterResponseProtocol registerResponse = response.registerResponse(jsonData);
        assertEquals(registerResponse.getRequest(), "/user/register.json");
        assertEquals(registerResponse.getResult(), "success");
        assertEquals(registerResponse.getDetails().getUserInfo().getUserID(), "userID");
        assertEquals(registerResponse.getDetails().getUserInfo().getUserName(), "userName");
        assertEquals(registerResponse.getDetails().getUserInfo().getUserNickname(), "userNickname");
        assertEquals(registerResponse.getDetails().getUserInfo().getUserEmail(), "userEmail");
        assertEquals(registerResponse.getDetails().getSessionID(), "111aaa111");
    }

    public void testChangeUserInfoResponse() {
        DeserializeResponse response = new DeserializeResponse();
        String jsonData = "{\"request\":\"/user/change_userinfo.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{\"userInfo\":{\"userID\":\"userID\",\"userName\":\"userName\",";
        jsonData += "\"userNickname\":\"userNickname\",\"userEmail\":\"userEmail\"}}}";

        ChangeUserInfoResponseProtocol changeUserInfoResponse = response.changeUserInfoResponse(jsonData);
        assertEquals(changeUserInfoResponse.getRequest(), "/user/change_userinfo.json");
        assertEquals(changeUserInfoResponse.getResult(), "success");
        assertEquals(changeUserInfoResponse.getDetails().getUserInfo().getUserID(), "userID");
        assertEquals(changeUserInfoResponse.getDetails().getUserInfo().getUserName(), "userName");
        assertEquals(changeUserInfoResponse.getDetails().getUserInfo().getUserNickname(), "userNickname");
        assertEquals(changeUserInfoResponse.getDetails().getUserInfo().getUserEmail(), "userEmail");
    }

    public void testUpdateTokenResponse() {
        DeserializeResponse response = new DeserializeResponse();
        String jsonData = "{\"request\":\"/user/update_token.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{\"sessionID\":\"111aaa111\"}}";

        UpdateTokenResponseProtocol updateTokenResponse = response.updateTokenResponse(jsonData);
        assertEquals(updateTokenResponse.getRequest(), "/user/update_token.json");
        assertEquals(updateTokenResponse.getResult(), "success");
        assertEquals(updateTokenResponse.getDetails().getSessionID(), "111aaa111");
    }
}