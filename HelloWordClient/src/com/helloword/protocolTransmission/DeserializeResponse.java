package com.helloword.protocolTransmission;

import com.google.gson.Gson;
import com.helloword.gsonObject.responseProtocol.ChangeUserInfoResponseProtocol;
import com.helloword.gsonObject.responseProtocol.LoginResponseProtocol;
import com.helloword.gsonObject.responseProtocol.LogoutResponseProtocol;
import com.helloword.gsonObject.responseProtocol.RegisterResponseProtocol;
import com.helloword.gsonObject.responseProtocol.UpdateTokenResponseProtocol;
import com.helloword.gsonObject.responseProtocol.VagueResponseProtocol;

/**
 * @author Liletta
 * Deserialize the responses from the server
 */
public class DeserializeResponse {
    
    private static final String DEBUG_TAG = null;

//    public void mainHandler(String toExtract) {
//        String[] availableHandlers = {
//            "/user/login.json",
//            "/user/logout.json",
//            "/user/register.json",
//            "/user/change_userinfo.json",
//            "/user/update_token.json"
//        };
//        
//        Gson gson = new Gson();
//        GlobalResponseProtocol responseData = new GlobalResponseProtocol();
//        responseData = gson.fromJson(toExtract, GlobalResponseProtocol.class);
//        String request = responseData.getRequest();
//        DeserializeResponse response = new DeserializeResponse();
//        
//        switch (Arrays.asList(availableHandlers).indexOf(request)) {
//        // will expand with further development to cater to different situation
//            case 0: response.loginResponse(toExtract); break;
//            case 1: response.logoutResponse(toExtract); break;
//            case 2: response.registerResponse(toExtract); break;
//            case 3: response.changeUserInfoResponse(toExtract); break;
//            case 4: response.updateTokenResponse(toExtract); break;
//            default: System.out.println("No handlers available");
//                 Log.e(DEBUG_TAG, "No handlers available");
//            
//        }
//    }

    public VagueResponseProtocol vagueResponse(String jsonData) {
        Gson gson = new Gson();
        VagueResponseProtocol responseData = new VagueResponseProtocol();
        responseData = gson.fromJson(jsonData, VagueResponseProtocol.class);
        return responseData;
    }


	public LoginResponseProtocol loginResponse(String jsonData) {
		Gson gson = new Gson();
		LoginResponseProtocol responseData = new LoginResponseProtocol();
		responseData = gson.fromJson(jsonData, LoginResponseProtocol.class);
		return responseData;
	}

    public LogoutResponseProtocol logoutResponse(String jsonData) {
        LogoutResponseProtocol responseData = new LogoutResponseProtocol();
        Gson gson = new Gson();
        responseData = gson.fromJson(jsonData, LogoutResponseProtocol.class);
        return responseData;
    }

    public RegisterResponseProtocol registerResponse(String jsonData) {
        RegisterResponseProtocol responseData = new RegisterResponseProtocol();
        Gson gson = new Gson();
        responseData = gson.fromJson(jsonData, RegisterResponseProtocol.class);
        return responseData;
    }

    public ChangeUserInfoResponseProtocol changeUserInfoResponse(String jsonData) {
        ChangeUserInfoResponseProtocol responseData = new ChangeUserInfoResponseProtocol();
        Gson gson = new Gson();
        responseData = gson.fromJson(jsonData, ChangeUserInfoResponseProtocol.class);
        return responseData;
    }

    public UpdateTokenResponseProtocol updateTokenResponse(String jsonData) {
        UpdateTokenResponseProtocol responseData = new UpdateTokenResponseProtocol();
        Gson gson = new Gson();
        responseData = gson.fromJson(jsonData, UpdateTokenResponseProtocol.class);
        return responseData;
    }    
    
}