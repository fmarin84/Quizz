package com.example.quizz.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="quizz")
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title",unique = true,nullable = false,length = 50)
    private String title;


    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name="quizz_id")
    private List<Question> questions = new ArrayList<>();

    public Quizz(String title) {
        this.title = title;
    }

    public Quizz() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quizz{" +
                "title='" + title + '\'' +
                '}';
    }
}
