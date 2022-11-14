package com.example.quizz.controller;

import com.example.quizz.UserDTO;
import com.example.quizz.entity.User;
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
    public UserDTO addUser(@RequestBody UserDTO user) throws Exception {
        userService.registerNewUserAccount(user);
        return user;
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
