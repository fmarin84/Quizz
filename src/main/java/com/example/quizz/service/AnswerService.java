package com.example.quizz.service;

import com.example.quizz.entity.Answer;
import com.example.quizz.repository.AnswerRepository;
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

    public void add(Answer anser){
        answerRepository.save(anser);
    }

    public List<Answer> getAll(){ return answerRepository.findAll();}

    public void deleteAnswer(int id) { answerRepository.deleteById(id);}

    public Optional<Answer> getAnswer(int id){
        return answerRepository.findById(id);
    }

    public void update(int id, Answer answer) throws Exception{
        if(id != answer.getId())
            throw new Exception();

        Optional<Answer> q = answerRepository.findById(id);
        if(q.isPresent()) {
            //TODO Faire une fonction
            q.get().setTitle(answer.getTitle());
            q.get().setRightWrong(answer.isRightWrong());
            answerRepository.save(answer);
        } else {
            throw new Exception();
        }
    }
}
