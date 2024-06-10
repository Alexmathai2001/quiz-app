package com.tutorial.quizApp.controller;

import com.tutorial.quizApp.repo.Questionrepo;
import com.tutorial.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allquestions")
    public ResponseEntity<List<Questionrepo>> allQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public  List<Questionrepo> getQuestionsByCategory(@PathVariable String category){

        return questionService.getQuestionsByCategory(category);

    }

    @PostMapping("/addquestion")
    public String addQuestion(@RequestBody Questionrepo question){
        return questionService.addQuestion(question);
    }
}
