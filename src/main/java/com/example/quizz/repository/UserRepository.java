package com.example.quizz.repository;

import com.example.quizz.entity.User;
import com.example.quizz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);

    Optional<User> findByEmail(String string);
}

