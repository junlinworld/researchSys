package com.example.sun.Dao;

import com.example.sun.pojo.Answer;
import com.example.sun.pojo.Question;
import com.example.sun.service.impl.AnswerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueDao {
    int insertQue(@Param("question") Question question);

    int deleteQueById(@Param("queId") int id);

    int updateQue(@Param("question") Question question);

    Question getQueById(@Param("queId") int id);

    Question getQueByDescribe(@Param("queDescribe") String queDescribe);


}

