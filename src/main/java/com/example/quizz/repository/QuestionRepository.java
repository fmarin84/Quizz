package com.example.quizz.repository;

import com.example.quizz.entity.Question;
import com.example.quizz.entity.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllByQuizz_Id(int id);

    Optional<Question> findByTitle(String nom);
    Optional<Question> findOneById(int id);

    long countDistinctByIdNotNull();
}
