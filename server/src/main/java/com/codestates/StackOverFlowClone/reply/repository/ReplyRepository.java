package com.codestates.StackOverFlowClone.reply.repository;

import com.codestates.StackOverFlowClone.reply.entity.Reply;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByQuestionId(long questionId);
    long countByQuestionId(long questionId);

}
