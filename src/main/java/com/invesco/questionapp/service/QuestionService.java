package com.invesco.questionapp.service;

import com.invesco.questionapp.model.Question;
import com.invesco.questionapp.model.response.Data;

public interface QuestionService {

    Data getAll() throws Exception;
    Data addQuestion(Question question) throws Exception;

}
