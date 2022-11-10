package com.example.quizz.repository;

import com.example.quizz.entity.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Integer> {
    List<Quizz> findAllByTitle(String nom);
    Optional<Quizz> findByTitle(String nom);
}
