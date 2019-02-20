package com.example.sun.pojo;

import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;
import java.util.List;

@Alias("research")
public class Research {
    @NotNull
    int researchId;
    @NotNull
    String researchTitle;
    @NotNull
    String researchStartDate;
    @NotNull
    String researchEndDate;
    @NotNull
    int researchGuest;
    List<Question> questions;
    List<Answer> answers;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getResearchId() {
        return researchId;
    }

    public void setResearchId(int researchId) {
        this.researchId = researchId;
    }

    public String getResearchTitle() {
        return researchTitle;
    }

    public void setResearchTitle(String researchTitle) {
        this.researchTitle = researchTitle;
    }

    public String getResearchStartDate() {
        return researchStartDate;
    }

    public void setResearchStartDate(String researchStartDate) {
        this.researchStartDate = researchStartDate;
    }

    public String getResearchEndDate() {
        return researchEndDate;
    }

    public void setResearchEndDate(String researchEndDate) {
        this.researchEndDate = researchEndDate;
    }


    public int getResearchGuest() {
        return researchGuest;
    }

    public void setResearchGuest(int researchGuest) {
        this.researchGuest = researchGuest;
    }

}
