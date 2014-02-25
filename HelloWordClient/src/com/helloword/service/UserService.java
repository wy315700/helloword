package com.helloword.service;

import com.helloword.gsonObject.responseProtocol.ChangeUserInfoResponseProtocol;
import com.helloword.gsonObject.responseProtocol.GetMessageResponseProtocol;
import com.helloword.gsonObject.responseProtocol.LoginResponseProtocol;
import com.helloword.gsonObject.responseProtocol.LogoutResponseProtocol;
import com.helloword.gsonObject.responseProtocol.RegisterResponseProtocol;
import com.helloword.gsonObject.responseProtocol.UpdateTokenResponseProtocol;
import com.helloword.protocolTransmission.DeserializeResponse;
import com.helloword.protocolTransmission.SerializeRequest;
import com.helloword.util.HttpLinker;
import com.helloword.util.Users;

/**
 * wrap the function of login, register and logout, etc
 *
 */
public class UserService {
    
    // not completed
        
	/**
	 * @param userName
	 * @param password
	 * @return the login result if fails return error string
	 */
	public String login(String userName,String password) {
		SerializeRequest request = new SerializeRequest();
		String stringUpload = request.loginRequest(userName, password);
		String httpUrl = "http://halloword.sinaapp.com/user/login.json";
		
		HttpLinker httpLinker = new HttpLinker();
		String stringDownload = httpLinker.stringPost(httpUrl, stringUpload);
		if (stringDownload != null) {
		    DeserializeResponse response = new DeserializeResponse();
	        LoginResponseProtocol loginResponse = response.loginResponse(stringDownload);
	        if (loginResponse.getResult().equals("success")) {
	            Users.sessionID = loginResponse.getDetails().getSessionID();
	            Users.userName = loginResponse.getDetails().getUserInfo().getUserName();
	            Users.userNickname = loginResponse.getDetails().getUserInfo().getUserNickname();
	            return "success";
	        }
	        else return loginResponse.getDetails().getError();
		}
		return "cannot receive data";
	}
	
	public String logout() {
	    return logout(Users.sessionID, Users.userName);
	}
	
	public String logout(String sessionID, String userName) {
	    SerializeRequest request = new SerializeRequest();
        String stringUpload = request.logoutRequest(sessionID, userName);
        String httpUrl = "http://halloword.sinaapp.com/user/logout.json";
        
        HttpLinker httpLinker = new HttpLinker();
        String stringDownload = httpLinker.stringPost(httpUrl, stringUpload);
        if (stringDownload != null) {
            DeserializeResponse response = new DeserializeResponse();
            LogoutResponseProtocol logoutResponse = response.logoutResponse(stringDownload);
            if (logoutResponse.getResult().equals("success")) return "success";
            else return logoutResponse.getDetails().getError();
        }
        return "cannot receive data";
	}
	
	public String register(String userName, String password, String userNickname) {
	    SerializeRequest request = new SerializeRequest();
	    String stringUpload = request.registerRequest(userName, userNickname, password);
	    String httpUrl = "http://halloword.sinaapp.com/user/register.json";
	    
	    HttpLinker httpLinker = new HttpLinker();
	    String stringDownload = httpLinker.stringPost(httpUrl, stringUpload);
	    if (stringDownload != null) {
            DeserializeResponse response = new DeserializeResponse();
            RegisterResponseProtocol registerResponse = response.registerResponse(stringDownload);
            if (registerResponse.getResult().equals("success")) return "success";
            else return registerResponse.getDetails().getError();
        }
        return "cannot receive data";
	}
	
	public String changeUserInfo(String userName, String userNickname, 
	        String oldPassword, String newPassword) {
	    return changeUserInfo(Users.sessionID, userName,
	            userNickname, oldPassword, newPassword);
	}
	
	public String changeUserInfo(String sessionID, String userName,
        String userNickname, String oldPassword, String newPassword) {

        SerializeRequest request = new SerializeRequest();
        String stringUpload = request.changeUserInfoRequest(sessionID, userName,
            userNickname, oldPassword, newPassword);
        String httpUrl = "http://halloword.sinaapp.com/user/change_userinfo.json";
        
        HttpLinker httpLinker = new HttpLinker();
        String stringDownload = httpLinker.stringPost(httpUrl, stringUpload);
        if (stringDownload != null) {
            DeserializeResponse response = new DeserializeResponse();
            ChangeUserInfoResponseProtocol changeUserInfoResponse = response.changeUserInfoResponse(stringDownload);
            if (changeUserInfoResponse.getResult().equals("success")) {
                Users.userName = changeUserInfoResponse.getDetails().getUserInfo().getUserName();
                Users.userNickname = changeUserInfoResponse.getDetails().getUserInfo().getUserNickname();
                return "success";
            }
            else return changeUserInfoResponse.getDetails().getError();
        }
        return "cannot receive data";
    }

    public String updateToken(String sessionID) {
        SerializeRequest request = new SerializeRequest();
        String stringUpload = request.updateTokenRequest(sessionID);
        String httpUrl = "http://halloword.sinaapp.com/user/update_token.json";
        
        HttpLinker httpLinker = new HttpLinker();
        String stringDownload = httpLinker.stringPost(httpUrl, stringUpload);
        if (stringDownload != null) {
            DeserializeResponse response = new DeserializeResponse();
            UpdateTokenResponseProtocol updateTokenResponse = response.updateTokenResponse(stringDownload);
            if (updateTokenResponse.getResult().equals("success")) {
                Users.sessionID = updateTokenResponse.getDetails().getSessionID();
                return "success";
            }
            else return updateTokenResponse.getDetails().getError();
        }
        return "cannot receive data";
    }
    
    public String getMessage() {
        return getMessage(Users.sessionID);
    }
    
    public String getMessage(String sessionID) {
        SerializeRequest request = new SerializeRequest();
        String stringUpload = request.getMessageRequest(sessionID);
        String httpUrl = "http://halloword.sinaapp.com/helloword/get_message.json";
        
        HttpLinker httpLinker = new HttpLinker();
        String stringDownload = httpLinker.stringPost(httpUrl, stringUpload, 1);
        if (stringDownload != null) {
            DeserializeResponse response = new DeserializeResponse();
            GetMessageResponseProtocol getMessageResponse = response.getMessageResponse(stringDownload);
            if (getMessageResponse.getResult().equals("success")) return "success";
            else return getMessageResponse.getDetails().getError();
        }
        return "cannot receive data";
        
    }
}
