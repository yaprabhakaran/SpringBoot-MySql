package com.invesco.questionapp.model.response;

public class QuestionResponse {

    Long id;
    String question;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {

        return question;
    }
}
