package com.example.sun.pojo;

import com.example.sun.SunApplicationTests;
import com.example.sun.service.impl.AnswerService;
import com.example.sun.service.impl.QueService;
import org.apache.catalina.LifecycleState;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


public class QuestionTest extends SunApplicationTests {

    @Autowired
    QueService queService = null;
    @Autowired
    AnswerService answerService = null;

    @Test
    public void insertQue() {

        System.out.println("aaaa");
//        List<Answer> answers = new ArrayList<>();
//        System.out.println("bbb");
//        Answer answer1 = new Answer();
//        answer1.setAnswerId(2);
//        answer1.setQuestionId(550);
//        answer1.setAnswerIndex(5);
//        answer1.setAnswerTitle("标准就是有钱");

//        List<Answer> answers = new ArrayList<>();
//        answers.add(answer1);

        List<Question> questionList = new ArrayList<>();
//        Question question1 = new Question();
//        question1.setQueId(600);
//        question1.setQueType("1");
//        question1.setQueResearchId(5);
//        question1.setQueDescribe("测试问题1");
//        question1.setAnswers(answers);

        for (int i = 0; i < 50; i++) {
            List<Answer> answerList = new ArrayList<>();
            for (int a = 0; a < 4; a++) {
                Answer ans = new Answer();
                ans.setAnswerTitle("answerTitle" + a);
                ans.setAnswerIndex(a);
//                ans.setQuestionId(600+i);
                answerList.add(ans);
            }

            Question question = new Question();
            question.setQueDescribe("Question Descibe" + i);
//            question.setQueId(600+i);
            question.setQueResearchId(5);
            question.setQueType("1");
            question.setAnswers(answerList);
            questionList.add(question);
        }


        System.out.println("开始插入问题......");

        for (int i = 0; i < questionList.size(); i++) {
            try {
                Question question1 = questionList.get(i);
                queService.insertQue(question1);
            } catch (Exception e) {
                System.out.println("插入异常-->" + e.getMessage());
            }
        }

//        try {
//            Question question1 = questions.get(0);
//            System.out.println(question1.getAnswers());
//            queService.insertQue(question1);
//        } catch (Exception e) {
//            System.out.println("插入异常-->" + e.getMessage());
//        }

//        System.out.println("插入问题成功");


    }

//    @Test
//    public void deleteQue() {
//
//        try {
//            System.out.println("开始删除......");
//            queService.deleteQueById(300);
//            System.out.println("删除成功");
//        } catch (Exception e) {
//            System.out.println("错误信息-->" + " " + e.getMessage());
//        }
//    }

    @Test
    public void updateQue() {
        List<Answer> answerList1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Answer answer = new Answer();
            answer.setAnswerIndex(i);
            answer.setAnswerTitle("answerTitleX" + i);
            answerList1.add(answer);
        }

        Question ques = new Question();
        ques.setQueType("2");
        ques.setQueResearchId(3);
        ques.setQueDescribe("Question Descibe6");
        ques.setAnswers(answerList1);


        try {
            queService.updateQue(ques);
        } catch (Exception e) {
            System.out.println("更新异常-->" + e.getMessage());

        }
    }

}
