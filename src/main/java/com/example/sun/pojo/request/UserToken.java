package com.example.sun.pojo.request;

import org.apache.ibatis.type.Alias;

@Alias("userToken")
public class UserToken {
    String userName;
    String token;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
