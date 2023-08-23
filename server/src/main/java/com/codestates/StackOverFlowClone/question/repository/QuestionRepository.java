package com.codestates.StackOverFlowClone.question.repository;

import com.codestates.StackOverFlowClone.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "select member_id from question where question_id = :questionId", nativeQuery = true)
    Long findMemberIdById(@Param("questionId") long questionId);

}
