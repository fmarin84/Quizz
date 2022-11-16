package com.example.quizz.controller;

import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.entity.Quizz;
import com.example.quizz.entity.User;
import com.example.quizz.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class QuizzApi {

    @Autowired
    QuizzService quizzService;

    @GetMapping("quizz")
    public List<Quizz> getAll(){

        return quizzService.getAll();
    }

    @GetMapping("quizz/{id}")
    public ResponseEntity getQuizz(@PathVariable("id") int id){
        Optional<Quizz> op = quizzService.getQuizz(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(op.get());
        }
    }

    @GetMapping("quizz/score/{id}")
    public HashMap getScore(@PathVariable("id") int id){
        Optional<Quizz> op = quizzService.getQuizz(id);

        int score = 0;
        HashMap<String, Integer> classement = new HashMap<>();

        if(op.isEmpty()){
            return  new HashMap<String,Integer>();
        } else {
            Quizz quizz = op.get();
            List<Question> questions = quizz.getQuestions();

            for (Question question : questions) {
                List<Answer> answers = question.getAnswers();

                for (Answer answer : answers) {
                    List<User> users = answer.getUserList();

                    if(answer.isRightWrong()){
                        //vrai

                        for (User user : users) {
                            if(classement.get(user.getUsername()) != null){
                                score = classement.get(user.getUsername()) + 1;
                            }else {
                                score++;
                            }

                            classement.put(user.getUsername(), score);
                            score = 0;
                        }
                    } else {
                        for (User user : users) {
                            if(classement.get(user.getUsername()) != null){
                                if(classement.get(user.getUsername()) >= 1){
                                    score = classement.get(user.getUsername()) - 1;
                                }
                            }

                            classement.put(user.getUsername(), score);
                            score = 0;
                        }
                    }
                }
            }

            return classement;
        }
    }
}
