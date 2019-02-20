package com.example.sun.Dao;

import com.example.sun.pojo.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultDao {
    int insertResult(@Param("result") Result result);

    int deleteResultById(@Param("resultId") int resultId);

    int updateResult(@Param("result") Result result);

    Result getResultById(@Param("resultId") int resultId);

}
