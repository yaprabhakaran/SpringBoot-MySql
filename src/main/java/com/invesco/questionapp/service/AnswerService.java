package com.invesco.questionapp.service;

import com.invesco.questionapp.model.Answer;
import com.invesco.questionapp.model.response.Data;

public interface AnswerService {

    Data getAnswers(Long id) throws Exception ;
    Data addAnswer(Long id, Answer answer) throws Exception;
}
