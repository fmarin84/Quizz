package com.example.quizz.controller;

import com.example.quizz.entity.Quizz;
import com.example.quizz.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin
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

    @GetMapping("findbytitle")
    public List<Quizz> findByTitle(@RequestParam(value = "title", required = false) String title){
        return quizzService.findByTitle(title);
    }
}
