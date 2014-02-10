package com.helloword.unitTest;

import junit.framework.TestCase;

import com.helloword.protocolTransmission.SerializeRequest;

public class TestRequestGson extends TestCase {
	
	public void testLoginRequest() {
		SerializeRequest request = new SerializeRequest();
		String result = request.loginRequest("Nana", "987d432");
		String rightResult = "{\"loginInfo\":{\"userName\":\"Nana\",\"password\":\"987d432\"},";
        rightResult += "\"request\":\"/user/login.json\"}";
		assertEquals(rightResult, result);
	}
	
	public void testLogoutRequest() {
		SerializeRequest request = new SerializeRequest();
		String result = request.logoutRequest("1234567", "Nana");
        String rightResult = "{\"logoutInfo\":{\"userName\":\"Nana\"},";
		rightResult += "\"request\":\"/user/logout.json\",\"sessionID\":\"1234567\"}";
		assertEquals(rightResult, result);
	}

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

	public void testUpdateTokenRequest() {
		SerializeRequest request = new SerializeRequest();
		String result = request.updateTokenRequest("111aaa111");
		String rightResult = "{\"request\":\"/user/update_token.json\",\"sessionID\":\"111aaa111\"}";
		assertEquals(rightResult, result);
	}
}