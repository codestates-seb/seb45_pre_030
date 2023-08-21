package com.codestates.StackOverFlowClone.reply.service;

import com.codestates.StackOverFlowClone.exception.BusinessLogicException;
import com.codestates.StackOverFlowClone.exception.ExceptionCode;
import com.codestates.StackOverFlowClone.member.service.MemberService;
import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.question.repository.QuestionRepository;
import com.codestates.StackOverFlowClone.question.service.QuestionService;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import com.codestates.StackOverFlowClone.reply.repository.ReplyRepository;
import com.codestates.StackOverFlowClone.utils.CustomBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;
    private final MemberService memberService;
    private final CustomBeanUtils<Reply> beanUtils;

    public ReplyService(ReplyRepository replyRepository,
                        QuestionService questionService,
                        QuestionRepository questionRepository,
                        MemberService memberService,
                        CustomBeanUtils<Reply> beanUtils) {
        this.replyRepository = replyRepository;
        this.questionService = questionService;
        this.questionRepository = questionRepository;
        this.memberService = memberService;
        this.beanUtils = beanUtils;
    }

    public Reply createReply(Reply reply) {
        Question question = verifyExistQuestion(reply);
        verifyOverReplyCount(question);
        return replyRepository.save(reply);
    }

    public Reply updateReply(Reply reply) {
        Reply findReply = findVerifiedReply(reply.getReplyId());

        Reply updatedReply =
                beanUtils.copyNonNullProperties(reply, findReply);

        // 본인만 답변 수정
        long tokenMemberId = memberService.findTokenMemberId();
        if(!isAuthenticatedMember(tokenMemberId, updatedReply.getMember().getMemberId())){
            throw new BusinessLogicException(ExceptionCode.UNAUTHORIZED);
        }

        return replyRepository.save(updatedReply);
    }

    public Reply updateReplyChoice(Reply reply) {
        Reply findReply = findVerifiedReply(reply.getReplyId());

        // 질문작성자만 선택가능
        long tokenMemberId = memberService.findTokenMemberId();
        long QuestionMemberId = questionRepository.findMemberIdById(findReply.getQuestion().getQuestionId());

        if(!isAuthenticatedMember(tokenMemberId, QuestionMemberId)){
            throw new RuntimeException();
        }

        findReply.setChoice(1L);

        return replyRepository.save(findReply);
    }

    public Reply findReply(long replyId) {
        return findVerifiedReply(replyId);
    }

    public List<Reply> findReplies() {
        return replyRepository.findAll();
    }

    public List<Reply> findQuestionReplies(long questionId) {
        Question question = questionService.findQuestion(questionId);
        return replyRepository.findAllByQuestion(question);
    }

    public void deleteReply(long replyId) {
        Reply reply = findVerifiedReply(replyId);

        // 본인만 답변 삭제
        long tokenMemberId = memberService.findTokenMemberId();
        if(!isAuthenticatedMember(tokenMemberId, reply.getMember().getMemberId())){
            throw new BusinessLogicException(ExceptionCode.UNAUTHORIZED);
        }

        replyRepository.delete(reply);
    }

    public Reply findVerifiedReply(long replyId) {
        Optional<Reply> optionalReply =
                replyRepository.findById(replyId);
        Reply findReply =
                optionalReply.orElseThrow(() -> new RuntimeException());

        return findReply;
    }

    public Question verifyExistQuestion(Reply reply) {
        Question question = questionService.findQuestion(reply.getQuestion().getQuestionId());
        return question;
    }

    public void verifyOverReplyCount(Question question) {
        if(question.getReplies().size() >= question.getReplyLimitCount())
            throw new RuntimeException();
    }

    public boolean isAuthenticatedMember(long tokenMemberId, long questionId){

        return tokenMemberId == questionId;
    }
}
