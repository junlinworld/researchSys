package com.example.sun.controllers;

import com.example.sun.Dao.QueDao;
import com.example.sun.pojo.Question;
import com.example.sun.result.FailResult;
import com.example.sun.result.ReturnResult;
import com.example.sun.result.SuccessResult;
import com.example.sun.service.QueSerface;
import com.example.sun.service.impl.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuesionController {

    @Autowired
    QueService queService = null;
    @Autowired
    SuccessResult successResult = null;
    @Autowired
    FailResult failResult = null;

    @RequestMapping(value = "/insertQue", method = RequestMethod.POST)
    public ReturnResult insertQue(Question question) {
        boolean flag = false;
        try {
            queService.insertQue(question);
            successResult.setStausEmessage("插入问题成功");
            successResult.setObject(question);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }
        return flag ? successResult : failResult;
    }

    @RequestMapping(value = "/deleteQue")
    public ReturnResult deleteQue(int queId) {
        boolean flag = false;
        try {
            successResult.setObject(queService.getQueById(queId));
            int a = queService.deleteQueById(queId);
            successResult.setStausEmessage("删除问题成功");
            flag = true;
        } catch (Exception e) {
            failResult.setObject(e.getMessage());
        }
        return flag ? successResult : failResult;
    }

    @RequestMapping(value = "/updateQue")
    public ReturnResult updateQue(Question question) {
        boolean flag = false;
        try {
            queService.updateQue(question);
            successResult.setStausEmessage("更新问题成功");
            successResult.setObject(question);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }
        return flag ? successResult : failResult;
    }

    @RequestMapping(value = "/getQueById")
    public ReturnResult getQueById(int queId) {
        boolean flag = false;
        try {
            Question a = queService.getQueById(queId);
            successResult.setStausEmessage("获取问题成功");
            successResult.setObject(a);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }
        return flag ? successResult : failResult;
    }


}
