package com.invesco.questionapp.model.response;

import java.util.List;

public class QuestionData extends Data {
    private List<QuestionResponse> data;

    public void setData(List<QuestionResponse> data) {
        this.data = data;
    }

    public List<QuestionResponse> getData() {

        return data;
    }
}
