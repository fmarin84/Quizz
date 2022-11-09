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

    public List<Quizz> getAllQuizz(){ return quizzRepository.findAll();}

    public void addQuizz(Quizz quizz){
        quizzRepository.save(quizz);
    }

    public void deleteQuizz(int id) { quizzRepository.deleteById(id);}

    public Optional<Quizz> getQuizz(int id){
        return quizzRepository.findById(id);
    }

    public void updateQuizz(int id, Quizz quizz) throws Exception{
        if(id != quizz.getId())
            throw new Exception();

        Optional<Quizz> q = quizzRepository.findById(id);
        if(q.isPresent()) {
            //TODO Faire une fonction
            quizz.setTitle(q.get().getTitle());
            quizzRepository.save(quizz);
        } else {
            throw new Exception();
        }
    }

    public List<Quizz> findByNom(String title){
        return quizzRepository.findAllByTitle(title);
    }

}
