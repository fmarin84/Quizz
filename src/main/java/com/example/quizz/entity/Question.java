package com.example.quizz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Quizz quizz;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="question_id")
    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                '}';
    }
}
