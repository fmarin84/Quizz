package com.example.quizz.controller;

import com.example.quizz.UserDTO;
import com.example.quizz.entity.User;
import com.example.quizz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
