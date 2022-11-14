package com.example.quizz.repository;

import com.example.quizz.entity.Answer;
import com.example.quizz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    Optional<User> findOneById(Integer integer);
}

