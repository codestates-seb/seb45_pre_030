package com.codestates.StackOverFlowClone.question.service;


import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.question.repository.QuestionRepository;
import com.codestates.StackOverFlowClone.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final CustomBeanUtils<Question> beanUtils;

    public QuestionService(QuestionRepository questionRepository, CustomBeanUtils<Question> beanUtils){
        this.questionRepository = questionRepository;
        this.beanUtils = beanUtils;
    }

    public Question createQuestion(Question question){

        return questionRepository.save(question);

    }

    public Question updateQuestion(Question question){

        Question findQuestion = findQuestion(question.getQuestionId());

        Question updatingQuestion =
                beanUtils.copyNonNullProperties(question, findQuestion);

        return questionRepository.save(updatingQuestion);
    }

    public Question findQuestion(long questionId){

        Optional<Question> optionalQuestion =
                questionRepository.findById(questionId);

        Question findQuestion = optionalQuestion.orElseThrow(()->new RuntimeException());

        return findQuestion;
    }

    public Page<Question> findQuestions(int page, int size){

        return questionRepository.findAll(PageRequest.of(page, size, Sort.by("questionId").ascending()));

    }

    public void increaseViewCount(Question question) {
        question.setViewCount(question.getViewCount()+1);
        questionRepository.save(question);
    }

    public void deleteQuestion(long questionId){

        Question findQuestion = findQuestion(questionId);

        questionRepository.delete(findQuestion);
    }
}
