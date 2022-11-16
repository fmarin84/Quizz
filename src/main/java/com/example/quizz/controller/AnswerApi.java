package com.example.quizz.controller;

import com.example.quizz.entity.Answer;
import com.example.quizz.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
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

    @PostMapping("answer")
    public Answer addUserAnswer(@RequestBody Answer answer){
        answerService.postUserAnswer(answer);
        return answer;
    }

}
