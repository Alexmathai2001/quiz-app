package com.tutorial.quizApp.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class QuestionWrapper {


    private Integer id;
    private String question;
    private String option1;
    private String option2;
    private String option3;

    public QuestionWrapper(Integer id, String question, String option1, String option2, String option3) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }
}
