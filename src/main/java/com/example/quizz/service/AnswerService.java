package com.example.quizz.service;

import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.repository.AnswerRepository;
import com.example.quizz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> getAnswers(int id){
        return answerRepository.findByQuestion_Id(id);
    }

    public Answer getAnswerValid(int id){
        return answerRepository.findByQuestion_IdAndRightWrongTrue(id);
    }
}
