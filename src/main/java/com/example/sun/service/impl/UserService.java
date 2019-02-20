package com.example.sun.service.impl;

import com.example.sun.Dao.UserDao;
import com.example.sun.pojo.User;
import com.example.sun.service.UserSerface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService extends BaseServiceImpl implements UserSerface {

    @Autowired
    UserDao userDao = null;

    @Override
    public int insertUser(User user) throws Exception {

        Validate(user);

//        User user1 = userDao.getUserByName(user.getUserName());
//        if (user1 != null) {
//
//            throw new Exception("该用户已存在");
//
//        }
//        return userDao.insert(user1);

        User user1 = userDao.getUserByName(user.getUserName());
        if (user1 != null) {
            throw new Exception("该用户已存在");
        }

        return userDao.insertUser(user);
    }

    @Override
    public int deleteUserById(int a) throws Exception {
        Validate(a);

        User user2 = userDao.getUserById(a);
        if (user2 == null) {
            throw new Exception("该用户不存在");
        }

        return userDao.deleteUserById(a);
    }

    @Override
    public int updateUser(User user) throws Exception {
        Validate(user);
        User user2 = userDao.getUserByName(user.getUserName());
        if (user2 == null) {
            throw new SQLException("该用户不存在");
        }
        return userDao.updateUser(user);
    }

    @Override
    public User getUserById(int a) throws Exception {
        User user = userDao.getUserById(a);
        if (user == null) {
            throw new Exception("该用户不存在");
        }

        return userDao.getUserById(a);
    }

    @Override
    public List<User> getallUser() {
        return userDao.getAllUser();
    }
}
