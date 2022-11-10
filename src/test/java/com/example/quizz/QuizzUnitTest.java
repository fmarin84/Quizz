package com.example.quizz;


import com.example.quizz.entity.Quizz;
import com.example.quizz.service.QuizzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QuizzUnitTest {

    @Autowired
    QuizzService quizzService;

    @Test
    void AddQuizz(){
        Quizz quizz = new Quizz("QuizzTest");

        quizzService.add(quizz);

        Optional<Quizz> quizzOptional = quizzService.getOneByTitle("QuizzTest");

        assertEquals(quizz.toString(),quizzOptional.get().toString());

        quizzService.deleteQuizz(quizzOptional.get().getId());

    }

    @Test
    void DeleteQuizz(){

        Optional<Quizz> quizzOptional = quizzService.getOneByTitle("QuizzTest");
        quizzService.deleteQuizz(quizzOptional.get().getId());

    }


}
