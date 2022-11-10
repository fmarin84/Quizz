package com.example.quizz;


import com.example.quizz.entity.Quizz;
import com.example.quizz.service.QuizzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QuizzTest {

    @Autowired
    QuizzService quizzService;

    @Test
    void AddQuizz(){
        Quizz quizz = new Quizz("Add a new quizz");

        quizzService.add(quizz);

        Optional<Quizz> quizzOptional = quizzService.getOneByTitle("Add a new quizz");

        assertEquals(quizz.toString(),quizzOptional.get().toString());

        quizzService.deleteQuizz(quizzOptional.get().getId());

    }

    @Test
    void DeleteQuizz(){

        Quizz quizz = new Quizz("Delete a quizz");
        quizzService.add(quizz);
        long countQuizzBeforeDelete =  quizzService.countDistinctByIdNotNull();

        Optional<Quizz> quizzOptional = quizzService.getOneByTitle("Delete a quizz");
        quizzService.deleteQuizz(quizzOptional.get().getId());

        long countQuizzAfterDelete =  quizzService.countDistinctByIdNotNull();

        assertNotEquals(countQuizzBeforeDelete,countQuizzAfterDelete);

    }

    @Test
    void UpdateQuizz() throws Exception {
        Quizz quizz = new Quizz("Update a quizz");
        quizzService.add(quizz);
        quizz.setTitle("Updated quizz");

        quizzService.update(quizz.getId(),quizz);

        Optional<Quizz> quizzOptional = quizzService.getOneByTitle("Updated quizz");

        assertEquals(true,quizzOptional.isPresent());

        quizzService.deleteQuizz(quizzOptional.get().getId());

    }


}
