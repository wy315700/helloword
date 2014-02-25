package com.helloword.unitTest;

import junit.framework.TestCase;

import org.junit.Test;

import com.helloword.gsonObject.responseProtocol.ChangeUserInfoResponseProtocol;
import com.helloword.gsonObject.responseProtocol.LoginResponseProtocol;
import com.helloword.gsonObject.responseProtocol.LogoutResponseProtocol;
import com.helloword.gsonObject.responseProtocol.RegisterResponseProtocol;
import com.helloword.gsonObject.responseProtocol.UpdateTokenResponseProtocol;
import com.helloword.gsonObject.responseProtocol.VagueResponseProtocol;
import com.helloword.protocolTransmission.DeserializeResponse;



public class ResponseGsonTest extends TestCase {
    
    @Test
    public void testVagueResponse() {
        String jsonData = "{\"request\":\"/user/register.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{\"userInfo\":{\"userID\":\"userID\",\"userName\":\"userName\",";
        jsonData += "\"userNickname\":\"userNickname\",\"userEmail\":\"userEmail\"},\"sessionID\":\"111aaa111\"}}";

        DeserializeResponse response = new DeserializeResponse();
        VagueResponseProtocol vagueResponse = response.vagueResponse(jsonData);
        assertEquals(vagueResponse.getRequest(), "/user/register.json");
        assertEquals(vagueResponse.getResult(), "success");
    }
    
    @Test
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
    
    @Test
    public void testLogoutResponse() {
        DeserializeResponse response = new DeserializeResponse();
        String jsonData = "{\"request\":\"/user/logout.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{}}";

        LogoutResponseProtocol logoutResponse = response.logoutResponse(jsonData);
        assertEquals(logoutResponse.getRequest(), "/user/logout.json");
        assertEquals(logoutResponse.getResult(), "success");
    }

    @Test
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

    @Test
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

    @Test
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

    @Test
    public void testGetMessageResponse() {
        DeserializeResponse response = new DeserializeResponse();
        String jsonData = "{\"request\":\"/helloword/get_message.json\",";
        jsonData += "\"result\":\"success\",";
        jsonData += "\"details\":{\"sessionID\":\"111aaa111\"}}";

        UpdateTokenResponseProtocol updateTokenResponse = response.updateTokenResponse(jsonData);
        assertEquals(updateTokenResponse.getRequest(), "/helloword/get_message.json");
        assertEquals(updateTokenResponse.getResult(), "success");
        assertEquals(updateTokenResponse.getDetails().getSessionID(), "111aaa111");
    }
}