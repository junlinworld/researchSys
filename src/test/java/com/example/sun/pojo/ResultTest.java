package com.example.sun.pojo;

import com.example.sun.SunApplicationTests;
import com.example.sun.service.impl.ResultService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultTest extends SunApplicationTests {
    @Autowired
    ResultService resultService = null;

    @Test
    public void insertResult() {

        for (int i = 0; i < 5; i++) {
            Result result1 = new Result();
            result1.setResultUser(1);
            result1.setResultResearchId(5);
            result1.setResultTime("2019-1-15 11:04:30");
            result1.setResultAnswer("answerTest" + i);
            result1.setResultQuestionId(i);

            try {
                resultService.insertResult(result1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
