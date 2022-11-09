package com.example.quizz.entity;

import javax.persistence.*;

@Entity
@Table(name="quizz")
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

}
