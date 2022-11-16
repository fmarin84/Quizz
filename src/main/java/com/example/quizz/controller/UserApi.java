package com.example.quizz.controller;

import com.example.quizz.UserDTO;
import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.entity.Quizz;
import com.example.quizz.entity.User;
import com.example.quizz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class UserApi {
    @Autowired
    UserService userService;

    @PostMapping("user")
    public UserDTO addUser(@RequestBody UserDTO user) throws Exception {
        userService.registerNewUserAccount(user);
        return user;
    }

    @PostMapping("user/login")
    public ResponseEntity Login(@RequestBody UserDTO user) throws Exception {

        User u = userService.login(user.getEmail(), user.getPassword());

        return ResponseEntity.ok().body(u);
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("user/quizz/{id}")
    public HashMap getQuizzByUser(@PathVariable("id") int id){
        Optional<User> userOptional = userService.getUser(id);

        int score = 0;
        HashMap<Integer, Boolean> classement = new HashMap<>();

        if(userOptional.isEmpty()){
            return  new HashMap<Integer,Integer>();
        } else {
            User user = userOptional.get();
            List<Answer> answers = user.getAnswerList();

            for (Answer answer : answers) {
                Question question = answer.getQuestion();
                Quizz quizz = question.getQuizz();

                classement.put(quizz.getId(), true);
            }

            return classement;
        }
    }

}
