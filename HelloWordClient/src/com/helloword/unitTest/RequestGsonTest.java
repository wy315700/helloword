/**
 * 
 */
package com.helloword.unitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.helloword.protocolTransmission.SerializeRequest;

/**
 * @author Liletta
 *
 */
public class RequestGsonTest {


    /**
     * Test method for {@link com.helloword.protocolTransmission.SerializeRequest#loginRequest(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testLoginRequest() {
        SerializeRequest request = new SerializeRequest();
        String result = request.loginRequest("Nana", "987d432");
        String rightResult = "{\"loginInfo\":{\"userName\":\"Nana\",\"password\":\"987d432\"},";
        rightResult += "\"request\":\"/user/login.json\"}";
        assertEquals(rightResult, result);
    }

    /**
     * Test method for {@link com.helloword.protocolTransmission.SerializeRequest#logoutRequest(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testLogoutRequest() {
        SerializeRequest request = new SerializeRequest();
        String result = request.logoutRequest("1234567", "Nana");
        String rightResult = "{\"logoutInfo\":{\"userName\":\"Nana\"},";
        rightResult += "\"request\":\"/user/logout.json\",\"sessionID\":\"1234567\"}";
        assertEquals(rightResult, result);
    }

    /**
     * Test method for {@link com.helloword.protocolTransmission.SerializeRequest#registerRequest(java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testRegisterRequest() {
        SerializeRequest request = new SerializeRequest();
        String userName = "Nana";
        String userNickname = "Ruby";
        String password = "123456";

        String result = request.registerRequest(userName, userNickname, password);
        String rightResult = "{\"userInfo\":{\"userName\":\"Nana\",\"password\":\"123456\",\"userNickname\":\"Ruby\"},";
        rightResult += "\"request\":\"/user/register.json\"}";
        assertEquals(rightResult, result);
    }

    /**
     * Test method for {@link com.helloword.protocolTransmission.SerializeRequest#changeUserInfoRequest(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testChangeUserInfoRequest() {
        SerializeRequest request = new SerializeRequest();
        String sessionID = "111aaa111";
        String userName = "Nana";
        String userNickname = "Ruby";
        String oldPassword = "123456";
        String newPassword = "654321";

        String result = request.changeUserInfoRequest(sessionID, userName, userNickname, oldPassword, newPassword);
        String rightResult = "{\"userInfo\":{\"oldPassword\":\"123456\",\"newPassword\":\"654321\",";
        rightResult += "\"userName\":\"Nana\",\"userNickname\":\"Ruby\"},";
        rightResult += "\"request\":\"/user/change_userinfo.json\",\"sessionID\":\"111aaa111\"}";
        assertEquals(rightResult, result);
    }

    /**
     * Test method for {@link com.helloword.protocolTransmission.SerializeRequest#updateTokenRequest(java.lang.String)}.
     */
    @Test
    public void testUpdateTokenRequest() {
        SerializeRequest request = new SerializeRequest();
        String result = request.updateTokenRequest("111aaa111");
        String rightResult = "{\"request\":\"/user/update_token.json\",\"sessionID\":\"111aaa111\"}";
        assertEquals(rightResult, result);
    }

}
