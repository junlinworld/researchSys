package com.example.sun.Dao;

import com.example.sun.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int insertUser(User user);

    int deleteUserById(@Param("userId") int userId);

    int updateUser(User user);

    User getUserById(@Param("userId") int userId);

    List<User> getAllUser();

    List<User> getTop20User();

    User getUserByName(@Param("userName") String userName);


}
