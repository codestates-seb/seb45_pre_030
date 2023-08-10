package com.codestates.StackOverFlowClone.question.repository;

import com.codestates.StackOverFlowClone.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
