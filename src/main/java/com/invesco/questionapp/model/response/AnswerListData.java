package com.invesco.questionapp.model.response;

import java.util.List;

public class AnswerListData extends Data{

    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
