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
@CrossOrigin
public class UserApi {
    @Autowired
    UserService userService;

    @PostMapping("user")
    public UserDTO addUser(@RequestBody UserDTO user) throws Exception {
        userService.registerNewUserAccount(user);
        return user;
    }

    @GetMapping("user")
    public ResponseEntity Login(@RequestParam String email, @RequestParam String password, BindingResult result) throws Exception {

        if (result.hasErrors()) {
            return ResponseEntity.status(400).body(result.getAllErrors().toArray());
        }
        User user = userService.login(email, password);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
