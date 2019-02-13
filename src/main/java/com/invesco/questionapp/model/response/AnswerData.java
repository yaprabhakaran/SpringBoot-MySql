package com.invesco.questionapp.model.response;

public class AnswerData extends Data {
    private AnswerResponse data;

    public void setData(AnswerResponse data) {

        this.data = data;
    }

    public AnswerResponse getData() {
        return data;
    }
}
