package com.example.sun.service;

import com.example.sun.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSerface {
    int insertUser(User user) throws Exception;

    int deleteUserById(int userId) throws Exception;

    int updateUser(User user) throws Exception;

    User getUserById(int userId) throws Exception;

    List<User> getallUser();
    User getUserByName(String userName) throws Exception;
}
