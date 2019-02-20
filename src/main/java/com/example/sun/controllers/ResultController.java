package com.example.sun.controllers;

import com.example.sun.pojo.Result;
import com.example.sun.result.FailResult;
import com.example.sun.result.ReturnResult;
import com.example.sun.result.SuccessResult;
import com.example.sun.service.impl.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.ScreenUpdateManager;

import java.awt.geom.FlatteningPathIterator;

@RestController
public class ResultController {

    @Autowired
    ResultService resultService = null;
    @Autowired
    SuccessResult successResult = null;
    @Autowired
    FailResult failResult = null;

    @RequestMapping("/insertResult")
    public ReturnResult insertResult(Result result) {

        boolean flag = false;
        try {
            resultService.insertResult(result);
            successResult.setStausEmessage("插入结果成功");
            successResult.setObject(result);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }

        return flag ? successResult : failResult;
    }

    @RequestMapping(value = "/deleteResult", method = RequestMethod.GET)
    public ReturnResult deleResult(int resultId) {
        boolean flag = false;

        try {
            resultService.deleteResultById(resultId);
            successResult.setStausEmessage("删除结果成功");
            successResult.setObject(resultService.getResultById(resultId));
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }
        return flag ? successResult : failResult;
    }

    @RequestMapping("/updateResult")
    public ReturnResult updateResult(Result result) {
        boolean flag = false;
        try {
            resultService.updateResult(result);
            successResult.setStausEmessage("更新结果成功");
            successResult.setObject(result);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }
        return flag ? successResult : failResult;
    }

    @RequestMapping("/getResultById")
    public ReturnResult getResultById(int resultId) {

        resultService.getResultById(resultId);
        successResult.setStausEmessage("获取结果成功");
        successResult.setObject(resultService.getResultById(resultId));

        return successResult;
    }
}
