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
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getById(int id){
        return userRepository.findById(id);
    }

    public User postUser(User user) { return userRepository.save(user); }


}
