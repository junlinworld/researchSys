package com.example.sun.service.impl;

import com.example.sun.Dao.AnswerDao;
import com.example.sun.Dao.QueDao;
import com.example.sun.pojo.Answer;
import com.example.sun.pojo.Question;
import com.example.sun.result.ReturnResult;
import com.example.sun.service.QueSerface;
import com.sun.org.apache.bcel.internal.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.net.Authenticator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class QueService extends BaseServiceImpl implements QueSerface {

    @Autowired
    QueDao queDao = null;
    @Autowired
    AnswerService answerService = null;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public int insertQue(Question question) throws Exception {

        Validate(question);

        //通过问题ID读取数据库，获取该问题对象。
        Question question1 = queDao.getQueById(question.getQueId());
        Question question2 = queDao.getQueByDescribe(question.getQueDescribe());

        //如果问题不为null，证明该问题已存在，抛出异常
        if (question2 != null) {
            throw new Exception("该问题已存在");
        }


        int i = queDao.insertQue(question);

        //循环把问题id赋值给答案id进行绑定,在插入问题的同时返回问题id
        for (int j = 0; j < question.getAnswers().size(); j++) {
            Answer answer = question.getAnswers().get(j);
            answer.setQuestionId(question.getQueId());
            System.out.println(answer.getQuestionId());
        }

        //插入对应答案
        answerService.insertAnswers(question.getAnswers());

        return i;


    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public int deleteQueById(int id) throws Exception {
        Question question = queDao.getQueById(id);
        if (question == null) {
            throw new Exception("该问题不存在");
        }

        int a = queDao.deleteQueById(id);

        int b = answerService.deleteAnswersByQueId(id);

        return a;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public int updateQue(Question question) throws Exception {
        Validate(question);

        Question question1 = queDao.getQueByDescribe(question.getQueDescribe());

        if (question1 == null) {
            throw new Exception("该问题不存在");
        }

        int i = queDao.updateQue(question);
//        Question question2 = queDao.getQueByDescribe(question.getQueDescribe());

        for (int j = 0; j < question.getAnswers().size(); j++) {
            Answer answer = question.getAnswers().get(j);
            //从根据问题描述获取到的问题当中，得到问题id，并且跟答案进行绑定（参数传进来的question不带有queId）
            answer.setQuestionId(question1.getQueId());
            answerService.updateAnswer(answer);

        }


        return i;


    }

    @Override
    public Question getQueById(int id) throws Exception {
        Question question = queDao.getQueById(id);

        if (question == null) {
            throw new Exception("该问题不存在");
        }
        return queDao.getQueById(id);

    }

    @Override
    public Question getQueByDescribe(String queDescribe) {


        return queDao.getQueByDescribe(queDescribe);
    }


}
