package com.example.sun.service;

import com.example.sun.pojo.Result;

public interface Resultface {
    int insertResult(Result result) throws Exception;

    int deleteResultById(int resultId) throws Exception;

    int updateResult(Result result) throws Exception;

    Result getResultById(int resultId);
}
