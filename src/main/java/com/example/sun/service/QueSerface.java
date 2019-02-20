package com.example.sun.service;

import com.example.sun.pojo.Answer;
import com.example.sun.pojo.Question;

import java.util.List;

public interface QueSerface {
    int insertQue(Question question) throws Exception;

    int deleteQueById(int id) throws Exception;

    int updateQue(Question question) throws Exception;

    Question getQueById(int id) throws Exception;

    Question getQueByDescribe(String queDescribe);


}

