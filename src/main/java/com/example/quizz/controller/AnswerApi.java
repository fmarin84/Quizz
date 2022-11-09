package com.example.quizz.controller;

import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.service.AnswerService;
import com.example.quizz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class AnswerApi {
    @Autowired
    AnswerService answerService;

    @GetMapping("answers/{id}")
    public List<Answer> getAnswers(@PathVariable("id") int id){
       return answerService.getAnswers(id);
    }

    @GetMapping("answer/{id}")
    public Answer getAnswerValid(@PathVariable("id") int id){
        return answerService.getAnswerValid(id);
    }

}
