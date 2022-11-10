package com.example.quizz;

import com.example.quizz.entity.Question;
import com.example.quizz.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class QuestionTest {
    @Autowired
    QuestionService questionService;

    @Test
    void AddQuizz(){
        Question question = new Question("Add a new question");

        questionService.add(question);

        Optional<Question> questionOptional = questionService.getOneByTitle("Add a new question");

        assertEquals(question.toString(),questionOptional.get().toString());

        questionService.deleteQuestion(questionOptional.get().getId());

    }

    @Test
    void DeleteQuizz(){

        Question question = new Question("Delete a question");
        questionService.add(question);
        long countQuestionBeforeDelete =  questionService.countDistinctByIdNotNull();

        Optional<Question> questionOptional = questionService.getOneByTitle("Delete a question");
        questionService.deleteQuestion(questionOptional.get().getId());

        long countQuestionAfterDelete =  questionService.countDistinctByIdNotNull();

        assertNotEquals(countQuestionBeforeDelete,countQuestionAfterDelete);

    }

    @Test
    void UpdateQuizz() throws Exception {

        Question question = new Question("Update a question");
        questionService.add(question);
        question.setTitle("Updated question");

        questionService.update(question.getId(),question);

        Optional<Question> questionOptional = questionService.getOneByTitle("Updated question");

        assertEquals(true,questionOptional.isPresent());

        questionService.deleteQuestion(questionOptional.get().getId());

    }
}
