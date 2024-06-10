package com.tutorial.quizApp.repo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Title;
    @ManyToMany
    private List<Questionrepo> Questions;

    public Quiz(){
        System.out.println("hello");
    }
}
