package com.tutorial.quizApp.service;

import com.tutorial.quizApp.dao.QuestionDao;
import com.tutorial.quizApp.repo.Questionrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    //get all questions from database
    public ResponseEntity<List<Questionrepo>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    //get questions regarding specific category
    public List<Questionrepo> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    //adding new question
    public String addQuestion(Questionrepo question) {
        questionDao.save(question);
        return "success";
    }
}
