package com.invesco.questionapp.service.impl;

import com.invesco.questionapp.constant.Constants;
import com.invesco.questionapp.model.Question;
import com.invesco.questionapp.model.response.Data;
import com.invesco.questionapp.model.response.QuestionData;
import com.invesco.questionapp.model.response.QuestionResponse;
import com.invesco.questionapp.respository.QuestionRepository;
import com.invesco.questionapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prabhakaran Karuppiah
 *
 * Service class for the Questions apis.
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    /**
     *
     * Gets all the questions.
     *
     * @return Data
     * @throws Exception
     *
     */
    public Data getAll() throws Exception{
        List<Question> questionList = questionRepository.findAll();
        return getQuestionResponse(questionList);
    }

    /**
     *
     * Adds question
     *
     * @param question
     * @return Data
     * @throws Exception
     *
     */
    public Data addQuestion(Question question) throws Exception{
        Data data= new Data();
        questionRepository.save(question);
        data.setSuccess(Constants.TRUE);
        return data;
    }

    public Data getQuestionResponse(List<Question> questionList){
        QuestionData data = new QuestionData();
        List<QuestionResponse> questionResponses = new ArrayList<>();
        for(Question question : questionList){
            QuestionResponse questionResponse = new QuestionResponse();
            questionResponse.setId(question.getQuestion_id());
            questionResponse.setQuestion(question.getQuestion());
            questionResponses.add(questionResponse);
        }
        data.setData(questionResponses);
        data.setSuccess(Constants.TRUE);
        return data;
    }
}
