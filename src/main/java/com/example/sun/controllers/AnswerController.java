package com.example.sun.controllers;

import com.example.sun.pojo.Answer;
import com.example.sun.result.FailResult;
import com.example.sun.result.ReturnResult;
import com.example.sun.result.SuccessResult;
import com.example.sun.service.impl.AnswerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService = null;
    @Autowired
    SuccessResult successResult = null;
    @Autowired
    FailResult failResult = null;

    @RequestMapping("/getAnswersByQueId")
    public ReturnResult getAnswersByQueId(int ansQueId) {
        boolean flag = false;
        List<Answer> answers = null;
        try {
            answers = answerService.getAnswersByQueId(ansQueId);
            successResult.setStausEmessage("获取答案成功");
            successResult.setObject(answers);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }


        return flag ? successResult : failResult;
    }

    @RequestMapping("/deleteAnswersByQueId")
    public ReturnResult deleteAnswersByQueId(int ansQueId) {
        boolean flag = false;
        try {
            answerService.deleteAnswersByQueId(ansQueId);
            successResult.setStausEmessage("答案删除成功");
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }
        return flag ? successResult : failResult;
    }


}
