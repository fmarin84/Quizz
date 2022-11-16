package com.example.quizz.service;

import com.example.quizz.entity.Quizz;
import com.example.quizz.repository.QuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizzService {

    @Autowired
    private QuizzRepository quizzRepository;

    public List<Quizz> getAll(){ return quizzRepository.findAll();}

    public void add(Quizz quizz){
        quizzRepository.save(quizz);
    }

    public void deleteQuizz(int id) { quizzRepository.deleteById(id);}

    public Optional<Quizz> getQuizz(int id){
        return quizzRepository.findOneById(id);
    }

    public void update(int id, Quizz quizz) throws Exception{
        if(id != quizz.getId())
            throw new Exception();
        Optional<Quizz> q = quizzRepository.findById(id);
        if(q.isPresent()) {
            quizz.setTitle(q.get().getTitle());
            quizz.setQuestions(q.get().getQuestions());
            quizzRepository.save(quizz);
        } else {
            throw new Exception();
        }
    }

    public long countDistinctByIdNotNull() { return quizzRepository.countDistinctByIdNotNull();}

    public List<Quizz> findByTitle(String title){
        return quizzRepository.findAllByTitle(title);
    }
    public Optional<Quizz> getOneByTitle(String title){
        return quizzRepository.findByTitle(title);
    }
}
