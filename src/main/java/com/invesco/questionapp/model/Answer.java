package com.invesco.questionapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Prabhakaran Karuppiah
 *
 *
 */

@Entity
@NamedNativeQuery(name = "Answer.findByQuestion_id",
        query="SELECT * FROM answer a WHERE a.question_id=:question_id",
        resultClass = Answer.class)
@Table(name = "answer")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;

    @Column(name="question_id")
    private Long question_id;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @Column(name="created_date",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;


    public Long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getCreatedAt() {
        return createdDate;
    }

    public void setCreatedAt(Date createdDate) {
        this.createdDate = createdDate;
    }
}
