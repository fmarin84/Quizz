package com.example.quizz;

import com.example.quizz.entity.Quizz;

import javax.validation.constraints.NotEmpty;

public class QuestionDTO {

    @NotEmpty(message = "Question ne peut pas être vide.")
    private String title;
    private com.example.quizz.entity.Quizz quizz;
    @NotEmpty(message = "Ce champs ne peut pas être vide.")
    private String answer1;
    @NotEmpty(message = "Ce champs ne peut pas être vide.")
    private String answer2;
    @NotEmpty(message = "Ce champs ne peut pas être vide.")
    private String answer3;

    @NotEmpty(message = "Ce champs ne peut pas être vide.")
    private String answer4;

    private boolean right1;
    private boolean right2;
    private boolean right3;
    private boolean right4;


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

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public boolean isRight1() {
        return right1;
    }

    public void setRight1(boolean right1) {
        this.right1 = right1;
    }

    public boolean isRight2() {
        return right2;
    }

    public void setRight2(boolean right2) {
        this.right2 = right2;
    }

    public boolean isRight3() {
        return right3;
    }

    public void setRight3(boolean right3) {
        this.right3 = right3;
    }

    public boolean isRight4() {
        return right4;
    }

    public void setRight4(boolean right4) {
        this.right4 = right4;
    }
}
