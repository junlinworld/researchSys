package com.example.sun.pojo;

import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;

@Alias("result")
public class Result {
    @NotNull
    int resultId;
    @NotNull
    int resultUser;
    @NotNull
    String resultAnswer;
    @NotNull
    String resultTime;
    @NotNull
    int resultQuestionId;
    @NotNull
    int resultResearchId;

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getResultUser() {
        return resultUser;
    }

    public void setResultUser(int resultUser) {
        this.resultUser = resultUser;
    }

    public String getResultAnswer() {
        return resultAnswer;
    }

    public void setResultAnswer(String resultAnswer) {
        this.resultAnswer = resultAnswer;
    }

    public String getResultTime() {
        return resultTime;
    }

    public void setResultTime(String resultTime) {
        this.resultTime = resultTime;
    }

    public int getResultQuestionId() {
        return resultQuestionId;
    }

    public void setResultQuestionId(int resultQuestionId) {
        this.resultQuestionId = resultQuestionId;
    }

    public int getResultResearchId() {
        return resultResearchId;
    }

    public void setResultResearchId(int resultResearchId) {
        this.resultResearchId = resultResearchId;
    }
}
