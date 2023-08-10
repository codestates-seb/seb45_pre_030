package com.codestates.StackOverFlowClone.reply.repository;

import com.codestates.StackOverFlowClone.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
