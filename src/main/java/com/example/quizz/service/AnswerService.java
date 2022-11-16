package com.example.quizz.service;

import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.entity.User;
import com.example.quizz.repository.AnswerRepository;
import com.example.quizz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Answer> getAnswers(int id){
        return answerRepository.findByQuestion_Id(id);
    }

    public Answer getAnswerValid(int id){
        return answerRepository.findByQuestion_IdAndRightWrongTrue(id);
    }

    public Optional<Answer> getById(int id){
        return answerRepository.findOneById(id);
    }

    public Answer postUserAnswer(Answer answer) {

        Answer a = answerRepository.findOneById(answer.getId()).get();
        User user = userRepository.findOneById(answer.getUserList().get(0).getId()).get();
        a.getUserList().add(user);
        return answerRepository.save(a);
    }

    //public List<Answer> getAnswerList(int id){
    //    return answerRepository.findByUser_Id(id);
    //}

    public void add(Answer answer){ answerRepository.save(answer); }

    public List<Answer> getAll(){ return answerRepository.findAll();}

    public void deleteAnswer(int id) { answerRepository.deleteById(id);}

    public Optional<Answer> getAnswer(int id){
        return answerRepository.findOneById(id);
    }

    public void update(int id, Answer answer) throws Exception{
        if(id != answer.getId())
            throw new Exception();

        Optional<Answer> q = answerRepository.findOneById(id);
        if(q.isPresent()) {
            
            q.get().setTitle(answer.getTitle());
            q.get().setRightWrong(answer.isRightWrong());
            answerRepository.save(answer);
        } else {
            throw new Exception();
        }
    }


    public Optional<Answer> getOneByTitle(String title){
        return answerRepository.findByTitle(title);
    }

    public long countDistinctByIdNotNull() { return answerRepository.countDistinctByIdNotNull();}
}
