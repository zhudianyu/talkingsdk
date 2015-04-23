package com.talkingsdk.models;

import java.util.HashMap;

public class LoginData {
    private String _userId;
    private String _username;
    private String _nickName;
    private String _password;
    private String _sessionId;
    private HashMap<String, String> _ex;

    public LoginData() {
        _ex = null;
    }

    public String getUserId() {
        return _userId;
    }

    public void setUserId(String userId) {
        this._userId = userId;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public String getNickName() {
        return _nickName;
    }

    public void setNickName(String nickName) {
        this._nickName = nickName;
    }

    public String getSessionId() {
        return _sessionId;
    }

    public void setSessionId(String sessionId) {
        this._sessionId = sessionId;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        this._password = password;
    }

    public HashMap<String, String> getEx() {
        if (null == _ex) {
            _ex = new HashMap<String, String>();
        }
        return _ex;
    }

    @Override
    public String toString() {
        return "LoginData [_userId=" + _userId + ", _username=" + _username + ", _nickName=" + _nickName
                + ", _password=" + _password + ", _sessionId=" + _sessionId
                + ", _ex=" + _ex + "]";
    }

}
