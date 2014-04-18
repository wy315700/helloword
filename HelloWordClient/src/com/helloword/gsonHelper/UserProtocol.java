package com.helloword.gsonHelper;

import com.google.gson.Gson;
import com.helloword.gsonObject.UserFullInfo;
import com.helloword.gsonObject.UserInfo;
import com.helloword.gsonObject.user.ChangeUserInfoRequest;
import com.helloword.gsonObject.user.ChangeUserInfoRequest.NewUserInfo;
import com.helloword.gsonObject.user.ChangeUserInfoResponse;
import com.helloword.gsonObject.user.GetMessageRequest;
import com.helloword.gsonObject.user.GetMessageResponse;
import com.helloword.gsonObject.user.LoginRequest;
import com.helloword.gsonObject.user.LoginResponse;
import com.helloword.gsonObject.user.LogoutRequest;
import com.helloword.gsonObject.user.LogoutResponse;
import com.helloword.gsonObject.user.RegisterRequest;
import com.helloword.gsonObject.user.RegisterResponse;
import com.helloword.gsonObject.user.UpdateTokenRequest;
import com.helloword.gsonObject.user.UpdateTokenResponse;
import com.helloword.gsonObject.user.VagueResponse;

public class UserProtocol {
    private Gson gson;

    public UserProtocol() {
        gson = new Gson();
    }

    public String requestLogin(String userName, String password) {
        LoginRequest loginRequest = new LoginRequest();
        UserInfo loginInfo = new UserInfo();

        loginInfo.setUserName(userName);
        loginInfo.setPassword(password);
        loginRequest.setRequest("/user/login.json");
        loginRequest.setLoginInfo(loginInfo);
        String loginJson = gson.toJson(loginRequest);
        return loginJson;
    }

    public LoginResponse responseLogin(String jsonGet) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse = gson.fromJson(jsonGet, LoginResponse.class);
        return loginResponse;
    }

    public String requestLogout(String sessionID, String userName) {
        UserFullInfo logoutInfo = new UserFullInfo();
        LogoutRequest logoutRequest = new LogoutRequest();

        logoutInfo.setUserName(userName);
        logoutRequest.setRequest("/user/logout.json");
        logoutRequest.setSessionID(sessionID);
        logoutRequest.setLogoutInfo(logoutInfo);

        String logoutJson = gson.toJson(logoutRequest);
        return logoutJson;
    }

    public LogoutResponse responseLogout(String jsonGet) {
        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse = gson.fromJson(jsonGet, LogoutResponse.class);
        return logoutResponse;
    }

    public String requestRegister(String userName, String userNickname,
            String password, String userAvatarType, String userAvatar) {
        UserFullInfo userInfo = new UserFullInfo();
        userInfo.setUserName(userName);
        userInfo.setUserNickname(userNickname);
        userInfo.setPassword(password);
        userInfo.setUserAvatarType(userAvatarType);
        userInfo.setUserAvatar(userAvatar);

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserInfo(userInfo);
        registerRequest.setRequest("/user/register.json");

        String registerJson = gson.toJson(registerRequest);
        return registerJson;
    }

    public RegisterResponse responseRegister(String jsonGet) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse = gson.fromJson(jsonGet, RegisterResponse.class);
        return registerResponse;
    }

    public String requestChangeUserInfo(String sessionID, String userName,
            String userNickname, String oldPassword, String newPassword,
            String userAvatarType, String userAvatar) {
        ChangeUserInfoRequest changeUserInfoRequest = new ChangeUserInfoRequest();
        ChangeUserInfoRequest.NewUserInfo userInfo = new NewUserInfo();
        userInfo.setUserName(userName);
        userInfo.setUserNickname(userNickname);
        userInfo.setOldPassword(oldPassword);
        userInfo.setNewPassword(newPassword);
        userInfo.setUserAvatarType(userAvatarType);
        userInfo.setUserAvatar(userAvatar);

        changeUserInfoRequest.setUserInfo(userInfo);
        changeUserInfoRequest.setRequest("/user/change_userinfo.json");
        changeUserInfoRequest.setSessionID(sessionID);

        String changeUserInfoJson = gson.toJson(changeUserInfoRequest);
        return changeUserInfoJson;
    }

    public ChangeUserInfoResponse responseChangeUserInfo(String jsonGet) {
        ChangeUserInfoResponse changeUserInfoResponse = new ChangeUserInfoResponse();
        changeUserInfoResponse = gson.fromJson(jsonGet,
                ChangeUserInfoResponse.class);
        return changeUserInfoResponse;
    }

    public String requestUpdateToken(String sessionID) {
        UpdateTokenRequest requestData = new UpdateTokenRequest();
        requestData.setRequest("/user/update_token.json");
        requestData.setSessionID(sessionID);

        String updateTokenJson = gson.toJson(requestData);
        return updateTokenJson;
    }

    public UpdateTokenResponse responseUpdateToken(String jsonGet) {
        UpdateTokenResponse updateTokenResponse = new UpdateTokenResponse();
        updateTokenResponse = gson.fromJson(jsonGet, UpdateTokenResponse.class);
        return updateTokenResponse;
    }

    public String requestGetMessage(String sessionID) {
        GetMessageRequest getMessageRequest = new GetMessageRequest();
        getMessageRequest.setRequest("/helloword/get_message.json");
        getMessageRequest.setSessionID(sessionID);

        String getMessageJson = gson.toJson(getMessageRequest);
        return getMessageJson;
    }

    public GetMessageResponse responseGetMessage(String jsonGet) {
        GetMessageResponse getMessageResponse = new GetMessageResponse();
        getMessageResponse = gson.fromJson(jsonGet, GetMessageResponse.class);
        return getMessageResponse;
    }

    public VagueResponse responseVague(String jsonGet) {
        VagueResponse vagueResponse = new VagueResponse();
        vagueResponse = gson.fromJson(jsonGet, VagueResponse.class);
        return vagueResponse;
    }

}