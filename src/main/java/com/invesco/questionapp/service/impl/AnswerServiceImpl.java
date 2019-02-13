package com.invesco.questionapp.service.impl;

import com.invesco.questionapp.constant.Constants;
import com.invesco.questionapp.model.Answer;
import com.invesco.questionapp.model.Question;
import com.invesco.questionapp.model.response.AnswerData;
import com.invesco.questionapp.model.response.AnswerListData;
import com.invesco.questionapp.model.response.AnswerResponse;
import com.invesco.questionapp.model.response.Data;
import com.invesco.questionapp.respository.AnswerRepository;
import com.invesco.questionapp.respository.QuestionRepository;
import com.invesco.questionapp.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    /**
     * Gets the answers for the question
     *
     * @param question_id
     * @return Data
     * @throws Exception
     *
     */
    public Data getAnswers(Long question_id) throws Exception{
        AnswerData data = new AnswerData();
        AnswerResponse answerResponse = new AnswerResponse();
        Question questionResponse = questionRepository.findById(question_id).orElse(new Question());
        List<Answer> answerList = answerRepository.findByQuestion_id(question_id);
        answerResponse.setId(questionResponse.getQuestion_id());
        answerResponse.setTitle(questionResponse.getTitle());
        answerResponse.setQuestion(questionResponse.getQuestion());
        answerResponse.setAnswers(getUpdatedAnswerResponse(answerList));
        data.setData(answerResponse);
        data.setSuccess(Constants.TRUE);

        return data;
    }

    /**
     * Adds answer to the question
     *
     * @param question_id
     * @param answer
     * @return
     * @throws Exception
     *
     */
    public Data addAnswer(Long question_id, Answer answer) throws Exception{
        AnswerListData data = new AnswerListData();
        answer.setQuestion_id(question_id);
        answerRepository.save(answer);
        data.setData(getUpdatedAnswerResponse(answerRepository.findByQuestion_id(question_id)));
        data.setSuccess(Constants.TRUE);
        return data;
    }

    public List<String> getUpdatedAnswerResponse(List<Answer> list){

        List<String> collect = list.stream()
                                    .map(x -> x.getAnswer()).collect(Collectors.toList());
        return collect;
    }
}
