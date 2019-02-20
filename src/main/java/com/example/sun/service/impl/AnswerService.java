package com.example.sun.service.impl;

import com.example.sun.Dao.AnswerDao;
import com.example.sun.pojo.Answer;
import com.example.sun.service.Answerface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnswerService extends BaseServiceImpl implements Answerface {

    @Autowired
    AnswerDao answerDao = null;


    @Override
    public int insertAnswer(Answer answer) throws Exception {
        Validate(answer);
        return answerDao.insertAnswer(answer);
    }

    @Override
    public int insertAnswers(List<Answer> answers) throws Exception {
        Validate(answers);
        return answerDao.insertAnswers(answers);
    }

    @Override
    public int deleteAnswersByQueId(int id) throws Exception {
        List<Answer> answers = answerDao.getAnswersByQueId(id);
        if (answers == null) {
            throw new Exception("对应答案不存在");
        }

        int a = answerDao.deleteAnswerByQueId(id);

        return a;
    }

    @Override
    public int updateAnswer(Answer answer) throws Exception {
        Validate(answer);
        return answerDao.updateAnswer(answer);
    }

    @Override
    public List<Answer> getAnswersByQueId(int queId) throws Exception {
        List<Answer> answers = answerDao.getAnswersByQueId(queId);
        if (answers.size() == 0) {
            throw new Exception("该答案不存在");
        }

        return answers;
    }
}
