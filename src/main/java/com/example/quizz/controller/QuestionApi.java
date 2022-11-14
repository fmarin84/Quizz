package com.example.quizz.controller;

import com.example.quizz.entity.Question;
import com.example.quizz.repository.QuestionRepository;
import com.example.quizz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class QuestionApi {

    @Autowired
    QuestionService questionService;

    @GetMapping("question/{id}")
    public ResponseEntity  getQuestion(@PathVariable("id") int id){

        Optional<Question> question = questionService.getQuestion(id);
        if(question.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(question.get());
        }
    }


    @GetMapping("questions/{id}")
    public List<Question> getQuestions(@PathVariable("id") int id){
        return questionService.getQuestions(id);
    }

}
