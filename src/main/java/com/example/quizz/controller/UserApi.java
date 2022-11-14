package com.example.quizz.controller;

import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Quizz;
import com.example.quizz.entity.User;
import com.example.quizz.service.AnswerService;
import com.example.quizz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class UserApi {
    @Autowired
    UserService userService;

    @PostMapping("user")
    public User addUser(@RequestBody User user) throws Exception {
        userService.add(user);
        return user;
    }
}
