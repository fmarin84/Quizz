package com.example.quizz;

import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.service.AnswerService;
import com.example.quizz.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class AnswerTest {
    @Autowired
    AnswerService answerService;

    @Test
    void AddAnswer(){
        Answer answer = new Answer("Add new answer");

        answerService.add(answer);

        Optional<Answer> answerOptional = answerService.getOneByTitle("Add new answer");

        assertEquals(answer.toString(),answerOptional.get().toString());

        answerService.deleteAnswer(answerOptional.get().getId());

    }

    @Test
    void DeleteAnswer(){

        Answer answer = new Answer("Delete an answer");
        answerService.add(answer);

        long countAnswerBeforeDelete =  answerService.countDistinctByIdNotNull();

        Optional<Answer> answerOptional = answerService.getOneByTitle("Delete an answer");
        answerService.deleteAnswer(answerOptional.get().getId());

        long countAnswerAfterDelete =  answerService.countDistinctByIdNotNull();

        assertNotEquals(countAnswerBeforeDelete,countAnswerAfterDelete);

    }

    @Test
    void UpdateAnswer() throws Exception {

        Answer answer = new Answer("Update an answer");
        answerService.add(answer);
        answer.setTitle("Updated answer");

        answerService.update(answer.getId(),answer);

        Optional<Answer> answerOptional = answerService.getOneByTitle("Updated answer");

        assertEquals(true,answerOptional.isPresent());

        answerService.deleteAnswer(answerOptional.get().getId());

    }
}
