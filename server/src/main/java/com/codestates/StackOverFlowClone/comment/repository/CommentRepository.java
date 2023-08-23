package com.codestates.StackOverFlowClone.comment.repository;

import com.codestates.StackOverFlowClone.comment.entity.Comment;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CommentRepository  extends JpaRepository<Comment, Long> {
    List<Comment> findAllByReply(Reply reply);
}
