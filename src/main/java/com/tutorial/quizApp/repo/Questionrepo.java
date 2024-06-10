package com.tutorial.quizApp.repo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Questionrepo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String category;
    private String answer;
}
