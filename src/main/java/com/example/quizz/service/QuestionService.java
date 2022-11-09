package com.example.quizz.service;

import com.example.quizz.entity.Question;
import com.example.quizz.entity.Quizz;
import com.example.quizz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestions(Quizz quizz){
        return questionRepository.findAllByQuizz(quizz);
    }

}
