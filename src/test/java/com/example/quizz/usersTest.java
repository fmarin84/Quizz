package com.example.quizz;

import com.example.quizz.entity.User;

import com.example.quizz.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@SpringBootTest
public class usersTest {

        @Autowired
        UserRepository userRepository;

        @Test
        void encodePassword() {

            User u = userRepository.findById(1).get();
            String password = new BCryptPasswordEncoder().encode("beanpassword");
            u.setPassword(password);
            userRepository.save(u);
        }

}
