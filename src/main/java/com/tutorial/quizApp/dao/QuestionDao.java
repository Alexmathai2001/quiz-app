package com.tutorial.quizApp.dao;

import com.tutorial.quizApp.repo.Questionrepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questionrepo,Integer> {

    List<Questionrepo> findByCategory(String category);

   @Query(value = "SELECT * FROM questionrepo q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Questionrepo> getRandomQuestionsByCategory(String category, Integer numQ);
}
