package com.example.quizz.entity;

import javax.persistence.*;

@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToOne
    private Quizz quizz;

    public Question() {
    }

    public Question(String title) {
        this.title = title;
    }


}
