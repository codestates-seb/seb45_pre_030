package com.codestates.StackOverFlowClone.reply.service;

import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.question.exception.BusinessLogicException;
import com.codestates.StackOverFlowClone.question.exception.ExceptionCode;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import com.codestates.StackOverFlowClone.reply.repository.ReplyRepository;
import com.codestates.StackOverFlowClone.utils.CustomBeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final CustomBeanUtils<Reply> beanUtils;

    public ReplyService(ReplyRepository replyRepository,CustomBeanUtils<Reply> beanUtils) {
        this.replyRepository = replyRepository;
        this.beanUtils = beanUtils;
    }

    public Reply createReply(Reply reply) {

        return replyRepository.save(reply);
    }

    public Reply updateReply(Reply reply) {
        Reply findReply = findVerifiedReply(reply.getReplyId());

        Reply updatedReply =
                beanUtils.copyNonNullProperties(reply, findReply);

        return replyRepository.save(updatedReply);
    }

    public Reply findReply(long replyId) {
        return findVerifiedReply(replyId);
    }

    public List<Reply> findReplies() {
        return replyRepository.findAll();
    }

    public void deleteReply(long replyId) {
        Reply reply = findVerifiedReply(replyId);
        replyRepository.delete(reply);
    }

    public Reply findVerifiedReply(long replyId) {
        Optional<Reply> optionalReply =
                replyRepository.findById(replyId);
        Reply findReply =
                optionalReply.orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND));

        return findReply;
    }
}
