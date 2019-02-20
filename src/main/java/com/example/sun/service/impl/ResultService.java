package com.example.sun.service.impl;

import com.example.sun.Dao.ResultDao;
import com.example.sun.Dao.UserDao;
import com.example.sun.pojo.Result;
import com.example.sun.service.Resultface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validation;

@Service
public class ResultService extends BaseServiceImpl implements Resultface {
    @Autowired
    ResultDao resultDao = null;


    @Override
    public int insertResult(Result result) throws Exception {
        Validate(result);
        Result result1 = resultDao.getResultById(result.getResultId());

        if (result1 != null) {
            throw new Exception("该结果已存在");
        }

        return resultDao.insertResult(result);
    }

    @Override
    public int deleteResultById(int resultId) throws Exception {
        Result result = resultDao.getResultById(resultId);

        if (result == null) {
            throw new Exception("该结果不存在");
        }
        return resultDao.deleteResultById(resultId);
    }

    @Override
    public int updateResult(Result result) throws Exception {
        Validate(result);
        Result result1 = resultDao.getResultById(result.getResultId());
        if (result1 == null) {
            throw new Exception("该结果不存在");
        }
        return resultDao.updateResult(result);
    }

    @Override
    public Result getResultById(int resultId) {
        return resultDao.getResultById(resultId);

    }
}
