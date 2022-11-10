package com.example.quizz.repository;

import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository  extends JpaRepository<Answer, Integer> {


    List<Answer> findByQuestion_Id(@NonNull Integer id);

    Answer findByQuestion_IdAndRightWrongTrue(@NonNull Integer id);

    //List<Answer> findByUser_Id(@NonNull Integer id);
    Optional<Answer> findByTitle(String nom);

    long countDistinctByIdNotNull();
}
