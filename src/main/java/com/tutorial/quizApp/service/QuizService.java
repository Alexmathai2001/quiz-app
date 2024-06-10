package com.tutorial.quizApp.service;

import com.tutorial.quizApp.dao.QuestionDao;
import com.tutorial.quizApp.dao.QuizDao;
import com.tutorial.quizApp.repo.QuestionWrapper;
import com.tutorial.quizApp.repo.Questionrepo;
import com.tutorial.quizApp.repo.Quiz;
import com.tutorial.quizApp.repo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Questionrepo> questions = questionDao.findByCategory(category);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("success save", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz;
        quiz = quizDao.findById(id);
        List<Questionrepo> questionFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for (Questionrepo q : questionFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questionrepo> questions = quiz.get().getQuestions();
        int i = 0;
        int Result = 0;

        for (Response response : responses){
            if (response.getResponse().equals(questions.get(i).getAnswer())){
                Result++;
            }
            i++;

        }
        return new ResponseEntity<>(Result , HttpStatus.OK);
    }
}
