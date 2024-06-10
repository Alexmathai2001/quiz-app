package com.tutorial.quizApp.dao;

import com.tutorial.quizApp.repo.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
