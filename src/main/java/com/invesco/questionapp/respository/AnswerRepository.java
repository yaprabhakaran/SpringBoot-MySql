package com.invesco.questionapp.respository;

import com.invesco.questionapp.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Prabhakaran Karuppiah
 *
 *
 */

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByQuestion_id(@Param("question_id") Long question_id);

}
