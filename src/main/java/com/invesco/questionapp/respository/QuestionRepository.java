package com.invesco.questionapp.respository;


import com.invesco.questionapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Prabhakaran Karuppiah
 *
 *
 */

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query
    public List<Question> findAll();
}
