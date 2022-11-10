package com.example.quizz.service;

import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.entity.User;
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

    public Optional<Answer> getById(int id){
        return answerRepository.findById(id);
    }

    public Answer postAnswer(Answer answer) { return answerRepository.save(answer); }

    //public List<Answer> getAnswerList(int id){
    //    return answerRepository.findByUser_Id(id);
    //}
}
