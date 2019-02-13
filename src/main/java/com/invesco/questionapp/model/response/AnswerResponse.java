package com.invesco.questionapp.model.response;

import java.util.List;

public class AnswerResponse {

    Long id;
    String title;
    String question;
    List<String> answers;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {

        return title;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {

        return question;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getAnswers() {

        return answers;
    }
}
