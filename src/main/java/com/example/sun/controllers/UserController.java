package com.example.sun.controllers;

import com.example.sun.Dao.UserDao;
import com.example.sun.pojo.User;
import com.example.sun.result.FailResult;
import com.example.sun.result.ReturnResult;
import com.example.sun.result.SuccessResult;
import com.example.sun.service.impl.BaseServiceImpl;
import com.example.sun.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sun.common.CrosConfiguration;

import javax.xml.bind.ValidationEvent;
import java.util.Scanner;

@RestController
public class UserController {

    @Autowired
    UserService userService = null;

    @Autowired
    SuccessResult successResult = null;

    @Autowired
    FailResult failResult = null;


//    @RequestMapping(value = "/get",method = RequestMethod.GET)
//
//    public Result get(int a){
////        return userDao.get(a);
//        return userService.get(a);
//
//    }

//    @RequestMapping("/getall")
//    public Result getall(){
//        return userService.getall();
//    }

//    @RequestMapping("/getTop20")
//    public List<User> getTop20(){
//        return userDao.getTop20();
//    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnResult insert(@RequestBody User user) {
        boolean flag = false;

        try {
            userService.insertUser(user);
            successResult.setStausEmessage("插入数据成功");
            successResult.setObject(user);
            flag = true;


        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());

        }
//        finally {
//            if (flag == false && (failResult.getStausEmessage() !=null || failResult.getStausEmessage().length() != 0) ){
//                failResult.setStausEmessage("未知错误");
//            }
//        }


        return flag ? successResult : failResult;
    }

    @RequestMapping(value = "/deleteUserById")
    public ReturnResult deleteUserById(int userId) {
        boolean flag = false;
        try {
            userService.deleteUserById(userId);
            successResult.setStausEmessage("删除用户成功");
            successResult.setObject(userService.getUserById(userId));
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }

        return flag ? successResult : failResult;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ReturnResult updateUser(@RequestBody User user) {
        boolean flag = false;
        try {
            userService.updateUser(user);
            successResult.setStausEmessage("更新成功");
            successResult.setObject(user);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }

        return flag ? successResult : failResult;
    }

    //    @CrossOrigin(origins = {"http://localhost:8080","null"})
    @RequestMapping(value = "/getUserById")
    public ReturnResult getUserById(int userId) {
        boolean flag = false;
        try {
            userService.getUserById(userId);
            successResult.setStausEmessage("获取用户成功!");
            successResult.setObject(userService.getUserById(userId));
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }


        return flag ? successResult : failResult;

    }

    @RequestMapping(value = "/getUserByName",method = RequestMethod.GET)
    public ReturnResult getUserByName(String userName){
        boolean flag = false;

        User user1 = null;
        try {
            user1 = userService.getUserByName(userName);
            successResult.setStausEmessage("获取用户成功");
            successResult.setObject(user1);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }

        return flag?successResult:failResult;
    }

    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    public String loginCheck(@RequestBody User inputUser){
        String type = "";

        try {
            User user = userService.getUserByName(inputUser.getUserName());
            if (user.getUserPassword().equals(inputUser.getUserPassword())){
                type = "success";
            }else {
                type = "fail";
            }
        } catch (Exception e) {
            type = e.getMessage();
        }

        return type;
    }
}
