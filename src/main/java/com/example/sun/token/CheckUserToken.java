package com.example.sun.token;

import com.example.sun.pojo.request.UserToken;
import org.apache.ibatis.type.Alias;

public  class CheckUserToken {
    public static boolean CheckUserToken(UserToken userToken) throws Exception {

        String name = JwtTokenUtil.verifyToken(userToken.getToken()).get("name").asString();
        if (userToken.getUserName().equals(name)){
            return true;
        }else {
            return false;
        }
    }
}
