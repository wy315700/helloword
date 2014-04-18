package com.helloword.service;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.helloword.gsonHelper.UserProtocol;
import com.helloword.gsonObject.user.ChangeUserInfoResponse;
import com.helloword.gsonObject.user.GetMessageResponse;
import com.helloword.gsonObject.user.LoginResponse;
import com.helloword.gsonObject.user.LogoutResponse;
import com.helloword.gsonObject.user.RegisterResponse;
import com.helloword.gsonObject.user.UpdateTokenResponse;
import com.helloword.util.HttpLinker;
import com.helloword.util.UsersApplication;

/**
 * wrap the function of user deeds like login, register and logout, etc
 * 
 */
public class UserService {
    private UsersApplication user;
    private UserProtocol userProtocol;
    private HttpLinker httpLinker;

    public UserService(Application application) {
        user = (UsersApplication) application;
        userProtocol = new UserProtocol();
        httpLinker = new HttpLinker();
    }

    // not completed

    /**
     * @param userName
     * @param password
     * @return the login result if fails return error string
     */
    public String login(String userName, String password) {
        String uploadString = userProtocol.requestLogin(userName, password);
        String httpUrl = "http://halloword.sinaapp.com/user/login.json";

        String downloadString = httpLinker.postString(httpUrl, uploadString);
        if (downloadString != null) {
            LoginResponse loginResponse = userProtocol
                    .responseLogin(downloadString);
            if (loginResponse.getResult().equals("success")) {
                user.setSessionID(loginResponse.getDetails().getSessionID());
                user.setUserName(loginResponse.getDetails().getUserInfo()
                        .getUserName());
                user.setUserNickname(loginResponse.getDetails().getUserInfo()
                        .getUserNickname());
                user.setUserAvatarType(loginResponse.getDetails().getUserInfo()
                        .getUserAvatarType());
                user.setUserAvatar(loginResponse.getDetails().getUserInfo()
                        .getUserAvatar());

                return "success";
            } else
                return loginResponse.getDetails().getError();
        }
        return "cannot receive data";
    }

    public String logout() {
        return logout(user.getSessionID(), user.getUserName());
    }

    public String logout(String sessionID, String userName) {
        String uploadString = userProtocol.requestLogout(sessionID, userName);
        String httpUrl = "http://halloword.sinaapp.com/user/logout.json";

        String downloadString = httpLinker.postString(httpUrl, uploadString);
        if (downloadString != null) {
            LogoutResponse logoutResponse = userProtocol
                    .responseLogout(downloadString);
            if (logoutResponse.getResult().equals("success"))
                return "success";
            else
                return logoutResponse.getDetails().getError();
        }
        return "cannot receive data";
    }

    public String register(String userName, String password,
            String userNickname, String userAvatarType, String userAvatar) {
        String uploadString = userProtocol.requestRegister(userName,
                userNickname, password, userAvatarType, userAvatar);
        String httpUrl = "http://halloword.sinaapp.com/user/register.json";

        String downloadString = httpLinker.postString(httpUrl, uploadString);
        if (downloadString != null) {
            RegisterResponse registerResponse = userProtocol
                    .responseRegister(downloadString);
            if (registerResponse.getResult().equals("success")) {
                user.setSessionID(registerResponse.getDetails().getSessionID());
                user.setUserName(registerResponse.getDetails().getUserInfo()
                        .getUserName());
                user.setUserNickname(registerResponse.getDetails()
                        .getUserInfo().getUserNickname());
                user.setUserAvatarType(registerResponse.getDetails()
                        .getUserInfo().getUserAvatarType());
                user.setUserAvatar(registerResponse.getDetails().getUserInfo()
                        .getUserAvatar());
                return "success";
            } else
                return registerResponse.getDetails().getError();
        }
        return "cannot receive data";
    }

    public String changeUserInfo(String userName, String userNickname,
            String oldPassword, String newPassword, String userAvatarType,
            String userAvatar) {

        return changeUserInfo(user.getSessionID(), userName, userNickname,
                oldPassword, newPassword, userAvatarType, userAvatar);
    }

    public String changeUserInfo(String sessionID, String userName,
            String userNickname, String oldPassword, String newPassword,
            String userAvatarType, String userAvatar) {

        String uploadString = userProtocol.requestChangeUserInfo(sessionID,
                userName, userNickname, oldPassword, newPassword,
                userAvatarType, userAvatar);
        String httpUrl = "http://halloword.sinaapp.com/user/change_userinfo.json";

        HttpLinker httpLinker = new HttpLinker();
        String downloadString = httpLinker.postString(httpUrl, uploadString);
        if (downloadString != null) {
            ChangeUserInfoResponse changeUserInfoResponse = userProtocol
                    .responseChangeUserInfo(downloadString);
            if (changeUserInfoResponse.getResult().equals("success")) {
                user.setUserName(changeUserInfoResponse.getDetails()
                        .getUserInfo().getUserName());
                user.setUserNickname(changeUserInfoResponse.getDetails()
                        .getUserInfo().getUserNickname());
                user.setUserAvatarType(changeUserInfoResponse.getDetails()
                        .getUserInfo().getUserAvatarType());
                user.setUserAvatar(changeUserInfoResponse.getDetails()
                        .getUserInfo().getUserAvatar());
                return "success";
            } else
                return changeUserInfoResponse.getDetails().getError();
        }
        return "cannot receive data";
    }

    public String updateToken(String sessionID) {
        String uploadString = userProtocol.requestUpdateToken(sessionID);
        String httpUrl = "http://halloword.sinaapp.com/user/update_token.json";

        String downloadString = httpLinker.postString(httpUrl, uploadString);
        if (downloadString != null) {
            UpdateTokenResponse updateTokenResponse = userProtocol
                    .responseUpdateToken(downloadString);
            if (updateTokenResponse.getResult().equals("success")) {
                user.setSessionID(updateTokenResponse.getDetails()
                        .getSessionID());
                return "success";
            } else
                return updateTokenResponse.getDetails().getError();
        }
        return "cannot receive data";
    }

    public String getMessage() {
        return getMessage(user.getSessionID());
    }

    public String getMessage(String sessionID) {
        String uploadString = userProtocol.requestGetMessage(sessionID);
        String httpUrl = "http://halloword.sinaapp.com/helloword/get_message.json";

        String downloadString = httpLinker.postString(httpUrl, uploadString, 1);
        if (downloadString != null) {
            GetMessageResponse getMessageResponse = userProtocol
                    .responseGetMessage(downloadString);
            if (getMessageResponse.getResult().equals("success"))
                return "success";
            else
                return getMessageResponse.getDetails().getError();
        }
        return "cannot receive data";

    }

    @SuppressLint("NewApi")
    public void turnAutoLoginOn() {
        String STORE_NAME = "Settings";
        SharedPreferences settings = user.getSharedPreferences(STORE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("autoLogin", true);
        try {
            editor.apply();
        } catch (Exception e) {
            editor.commit();
        }
    }

    public boolean isAutoLoginOn() {
        String STORE_NAME = "Settings";
        SharedPreferences settings = user.getSharedPreferences(STORE_NAME,
                Context.MODE_PRIVATE);
        boolean autoLogin = settings.getBoolean("autoLogin", false);
        return autoLogin;
    }

    @SuppressLint("NewApi")
    public boolean saveUserInfo(String userName, String password) {
        // XXX try to find out the mean of boolean return
        String STORE_NAME = "Settings";
        SharedPreferences settings = user.getSharedPreferences(STORE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        if (userName != null && password != null) {
            editor.putString("userName", userName);
            editor.putString("password", password);
        }
        try {
            editor.apply();
        } catch (Exception e) {
            editor.commit();
        }
        return true;
    }

    public String[] getUserInfo() {
        String STORE_NAME = "Settings";
        SharedPreferences settings = user.getSharedPreferences(STORE_NAME,
                Context.MODE_PRIVATE);
        String userName = settings.getString("userName", null);
        String password = settings.getString("password", null);
        return new String[] { userName, password };
    }
}
