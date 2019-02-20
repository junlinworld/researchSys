package com.example.sun.Dao;

import com.example.sun.pojo.Answer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDao {
    int insertAnswer(Answer answer);

    int insertAnswers(@Param("AnswerList") List<Answer> answerList);

    int deleteAnswerByQueId(@Param("ansQueId") int ansQueId);

    int updateAnswer(@Param("answer") Answer answer);

    List<Answer> getAnswersByQueId(@Param("queId") int queId);

}
