package com.invesco.questionapp.controller;


import com.invesco.questionapp.model.Answer;
import com.invesco.questionapp.model.Question;
import com.invesco.questionapp.model.response.Data;
import com.invesco.questionapp.service.AnswerService;
import com.invesco.questionapp.service.QuestionService;
import com.invesco.questionapp.util.QuestionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import javax.validation.Valid;

/**
 *
 * @author Prabhakaran Karuppiah
 *
 * Controller for the Question app
 *
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class QuestionAppController {

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    /**
     * API which adds new question the list.
     *
     * @param question
     * @return Data
     *
     */
    @PostMapping("/question")
    public Data addQuestion(@Valid @RequestBody Question question) {
        Data data = null;
        try {
            data =  questionService.addQuestion(question);
        }catch(Exception ex){
            data = QuestionUtil.getDataWithError();
        }
        return data;
    }

    /**
     *
     * API which gets the list of all questions
     * @return Data
     */

    @GetMapping("/question")
    public Data getAllQuestions() {
        Data data = null;
        try {
            data =  questionService.getAll();
        }catch(Exception ex){
            data = QuestionUtil.getDataWithError();
        }
        return data;
    }

    /**
     * API which gets list of answers for the question
     * @param question_id
     * @return Data
     */
    @GetMapping("/question/{id}")
    public Data getAnswersById(@PathVariable(value = "id") Long question_id) {
        Data data = null;
        try {
            data =  answerService.getAnswers(question_id);
        }catch(Exception ex){
            data = QuestionUtil.getDataWithError();
        }
        return data;

    }

    /**
     *
     * Adds answer to the question
     *
     * @param questionId
     * @param answer
     * @return Data
     */
    @PutMapping("/question/{id}")
    public Data updateAnswer(@PathVariable(value = "id") Long questionId,
                           @Valid @RequestBody Answer answer) {

        Data data = null;
        try {
            data =  answerService.addAnswer(questionId,answer);
        }catch(Exception ex){
            data = QuestionUtil.getDataWithError();
        }
        return data;
    }


}
