package com.example.sun.controllers;

import com.example.sun.Dao.UserDao;
import com.example.sun.pojo.User;
import com.example.sun.pojo.request.UserToken;
import com.example.sun.result.FailResult;
import com.example.sun.result.ReturnResult;
import com.example.sun.result.SuccessResult;
import com.example.sun.service.impl.BaseServiceImpl;
import com.example.sun.service.impl.UserService;
import com.example.sun.token.CheckUserToken;
import com.example.sun.token.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sun.common.CrosConfiguration;

import javax.validation.Valid;
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

    @RequestMapping(value = "/getUserByName")
    public ReturnResult getUserByName(@RequestBody UserToken userToken){
        System.out.println("userToken--> "+userToken);
        boolean flag = false;
        System.out.println("token--> " + userToken.getToken());
        User user1 = null;



        try {
            if (CheckUserToken.CheckUserToken(userToken) == true){

            }else {
                failResult.setStausEmessage("验证失败");
                return  failResult;
            }

//            String name =  JwtTokenUtil.verifyToken(userToken.getToken()).get("name").asString();
//            System.out.println("name:" +name);

            successResult.setStausEmessage("获取用户成功");
            user1 = userService.getUserByName(userToken.getUserName());
            successResult.setObject(user1);
            flag = true;

        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }

        return flag?successResult:failResult;
    }

    //接收的json格式，对象的话，必须要用@requestBody注解，@Vaid则启用User里面notNull等规则
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    public ReturnResult loginCheck(@RequestBody @Valid User inputUser){
        boolean flag = false;

        try {
            User user = userService.getUserByName(inputUser.getUserName());
            if (user.getUserPassword().equals(inputUser.getUserPassword())){
                successResult.setStausEmessage("验证通过");
                //调用token类方法生成token密文，放到返回类object里面发回前端，参数为userName
                successResult.setObject(JwtTokenUtil.createToken(inputUser.getUserName()));
//                System.out.println("密文："+JwtTokenUtil.createToken(inputUser.getUserName()));
                flag = true;
            }else {
                failResult.setStausEmessage("验证失败");
            }
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }

        return flag?successResult:failResult;
    }
}
