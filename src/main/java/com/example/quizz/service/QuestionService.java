package com.example.quizz.service;

import com.example.quizz.entity.Question;
import com.example.quizz.entity.Quizz;
import com.example.quizz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAll(){ return questionRepository.findAll();}

    public void add(Question question){
        questionRepository.save(question);
    }

    public List<Question> getQuestions(int id){
        return questionRepository.findAllByQuizz_Id(id);
    }

    public Optional<Question> getQuestion(int id){
        return questionRepository.findById(id);
    }

}
