package com.codestates.StackOverFlowClone.question.service;


import com.codestates.StackOverFlowClone.exception.BusinessLogicException;
import com.codestates.StackOverFlowClone.exception.ExceptionCode;
import com.codestates.StackOverFlowClone.member.service.MemberService;
import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.question.repository.QuestionRepository;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import com.codestates.StackOverFlowClone.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final MemberService memberService;

    private final CustomBeanUtils<Question> beanUtils;

    public QuestionService(QuestionRepository questionRepository, MemberService memberService, CustomBeanUtils<Question> beanUtils){
        this.questionRepository = questionRepository;
        this.memberService = memberService;
        this.beanUtils = beanUtils;
    }

    public Question createQuestion(Question question){

        return questionRepository.save(question);

    }

    public Question updateQuestion(Question question){

        Question findQuestion = findQuestion(question.getQuestionId());



        // 본인만 게시물 수정
        long tokenMemberId = memberService.findTokenMemberId();
        if(!isAuthenticatedMember(tokenMemberId, findQuestion.getMember().getMemberId())){
            throw new BusinessLogicException(ExceptionCode.UNAUTHORIZED);
        }
        Question updatingQuestion =
                beanUtils.copyNonNullProperties(question, findQuestion);

        return questionRepository.save(updatingQuestion);
    }

    public Question findQuestion(long questionId){

        Optional<Question> optionalQuestion =
                questionRepository.findById(questionId);

        Question findQuestion = optionalQuestion.orElseThrow(()->new RuntimeException());

        for(Reply reply : findQuestion.getReplies()){
            if(reply.getChoice() == 1) findQuestion.setReplyChoice(1L);
        }

        findQuestion.setReplyCount(findQuestion.getReplies().size());

        return findQuestion;
    }

    public Page<Question> findQuestions(int page, int size){

        Page<Question> pageQuestion = questionRepository.findAll(PageRequest.of(page, size, Sort.by("questionId").ascending()));

        for(Question question : pageQuestion){
            for(Reply reply : question.getReplies()){
                if(reply.getChoice() == 1) question.setReplyChoice(1L);
            }
        }

        for(Question question : pageQuestion){
            question.setReplyCount(question.getReplies().size());
        }

        return pageQuestion;

    }

    public void increaseViewCount(Question question) {
        question.setViewCount(question.getViewCount()+1);
        questionRepository.save(question);
    }

    public void deleteQuestion(long questionId){

        Question findQuestion = findQuestion(questionId);

        // 본인만 게시물 삭제
        long tokenMemberId = memberService.findTokenMemberId();
        if(!isAuthenticatedMember(tokenMemberId, findQuestion.getMember().getMemberId())){
            throw new BusinessLogicException(ExceptionCode.UNAUTHORIZED);
        }

        questionRepository.delete(findQuestion);
    }

    public boolean isAuthenticatedMember(long tokenMemberId, long questionId){

        return tokenMemberId == questionId;
    }

}
