package com.example.quizz.service;

import com.example.quizz.QuestionDTO;
import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.entity.Quizz;
import com.example.quizz.entity.User;
import com.example.quizz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerService answerService;
    public List<Question> getAll(){ return questionRepository.findAll();}

    public void add(Question question){
        questionRepository.save(question);
    }

    public void addDTO(QuestionDTO questionDTO){
        System.out.println(questionDTO);

        Question question = new Question();
        question.setTitle(questionDTO.getTitle());
        question.setQuizz(questionDTO.getQuizz());

        question.getAnswers().add(new Answer(questionDTO.getAnswer1(), questionDTO.isRight1()));
        question.getAnswers().add(new Answer(questionDTO.getAnswer2(), questionDTO.isRight2()));
        question.getAnswers().add(new Answer(questionDTO.getAnswer3(), questionDTO.isRight3()));
        question.getAnswers().add(new Answer(questionDTO.getAnswer4(), questionDTO.isRight4()));

        questionRepository.save(question);
    }

    public List<Question> getQuestions(int id){
        return questionRepository.findAllByQuizz_Id(id);
    }

    public Optional<Question> getQuestion(int id){
        return questionRepository.findOneById(id);
    }


    public void update(int id, Question question) throws Exception{
        if(id != question.getId())
            throw new Exception();

        Optional<Question> q = questionRepository.findById(id);
        if(q.isPresent()) {
            question.setAnswers(q.get().getAnswers());
            questionRepository.save(question);
        } else {
            throw new Exception();
        }
    }

    public void deleteQuestion(int id) { questionRepository.deleteById(id);}

    public Optional<Question> getOneByTitle(String title){
        return questionRepository.findByTitle(title);
    }

    public long countDistinctByIdNotNull() { return questionRepository.countDistinctByIdNotNull();}
}
