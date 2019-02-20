package com.example.sun.pojo;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Alias("question")
public class Question {
    @NotNull
    int queId;
    @NotNull
    String queType;

    @NotNull
    String queDescribe;
    @NotNull
    int queResearchId;
    //    @NotNull
    List<Answer> answers;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getQueId() {
        return queId;
    }

    public void setQueId(int queId) {
        this.queId = queId;
    }

    public String getQueType() {
        return queType;
    }

    public void setQueType(String queType) {
        this.queType = queType;
    }

    public String getQueDescribe() {
        return queDescribe;
    }

    public void setQueDescribe(String queDescribe) {
        this.queDescribe = queDescribe;
    }

    public int getQueResearchId() {
        return queResearchId;
    }

    public void setQueResearchId(int queResearchId) {
        this.queResearchId = queResearchId;
    }
}
