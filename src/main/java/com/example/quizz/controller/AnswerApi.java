package com.example.quizz.controller;

import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.service.AnswerService;
import com.example.quizz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin
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
    public Answer addAnswer(@RequestBody Answer answer){
        answerService.postAnswer(answer);
        return answer;
    }

    //@GetMapping("getAnswerList/{id}")
    //public List<Answer> getAnswerList(@PathVariable("id") int idUser){
    //    return answerService.getAnswerList(idUser);
    //}
}
