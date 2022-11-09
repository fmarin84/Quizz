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

    @Column(name="title")
    private String title;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="question_id ")
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

    @Override
    public String toString() {
        return "Quizz{" +
                "title='" + title + '\'' +
                '}';
    }
}
