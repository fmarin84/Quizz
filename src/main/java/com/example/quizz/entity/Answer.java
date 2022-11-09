package com.example.quizz.entity;

import javax.persistence.*;

@Entity
@Table(name="answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToOne
    private Question question;

    private boolean rightWrong;

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


    public boolean isRightWrong() {
        return rightWrong;
    }

    public void setRightWrong(boolean rightWrong) {
        this.rightWrong = rightWrong;
    }



    public Answer() {
    }

    public Answer(String title) {
        this.title = title;
    }



}
