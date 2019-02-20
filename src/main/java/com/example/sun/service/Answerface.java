package com.example.sun.service;

import com.example.sun.pojo.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Answerface {
    int insertAnswer(Answer answer) throws Exception;

    int insertAnswers(List<Answer> answers) throws Exception;

    int deleteAnswersByQueId(int answerId) throws Exception;

    int updateAnswer(Answer answer) throws Exception;

    List<Answer> getAnswersByQueId(@Param("queId") int queId) throws Exception;


}
