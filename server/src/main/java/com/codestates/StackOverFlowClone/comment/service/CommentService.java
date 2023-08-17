package com.codestates.StackOverFlowClone.comment.service;

import com.codestates.StackOverFlowClone.comment.entity.Comment;
import com.codestates.StackOverFlowClone.comment.repository.CommentRepository;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import com.codestates.StackOverFlowClone.reply.service.ReplyService;
import com.codestates.StackOverFlowClone.utils.CustomBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;
    private final ReplyService replyService;
    private final CustomBeanUtils<Comment> beanUtils;

    public CommentService(CommentRepository commentRepository,
                          ReplyService replyService, CustomBeanUtils<Comment> beanUtils) {
        this.commentRepository = commentRepository;
        this.replyService = replyService;
        this.beanUtils = beanUtils;
    }

    public Comment createComment(Comment comment) {
//        Reply reply = verifyExistReply(comment);
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        Comment findComment = verifyExistComment(comment.getCommentId());
        Comment updatedComment =
                beanUtils.copyNonNullProperties(comment, findComment);

        return commentRepository.save(updatedComment);
    }

    public Comment findComment(long commentId) {
        return verifyExistComment(commentId);
    }

    public List<Comment> findCommentsInReply(long replyId) {
        Reply reply = replyService.findReply(replyId);
        return commentRepository.findAllByReply(reply);
    }

    public void deleteComment(long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        Comment findComment = comment.orElseThrow(() -> new RuntimeException());
        commentRepository.delete(findComment);
    }

    public Comment verifyExistComment(long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        return comment.orElseThrow(() -> new RuntimeException());
    }
//    public Reply verifyExistReply(Comment comment) {
//        Reply reply = replyService.findReply(comment.getReply().getReplyId());
//        return reply;
//    }
}
