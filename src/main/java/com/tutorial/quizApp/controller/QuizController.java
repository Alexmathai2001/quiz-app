package com.tutorial.quizApp.controller;

import com.tutorial.quizApp.repo.QuestionWrapper;
import com.tutorial.quizApp.repo.Response;
import com.tutorial.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    //creating questions
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        System.out.println(category + numQ + title);
        return quizService.createQuiz(category,numQ,title) ;
    }

    //getting quiz questions for the user
    @GetMapping("getquiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }


    //calculating the mark of the user
    @PostMapping("/result/{id}")
    public ResponseEntity<Integer> result(@PathVariable Integer id , @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }

}
