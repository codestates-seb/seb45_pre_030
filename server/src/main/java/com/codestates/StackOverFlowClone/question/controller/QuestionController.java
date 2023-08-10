package com.codestates.StackOverFlowClone.question.controller;


import com.codestates.StackOverFlowClone.question.dto.QuestionPatchDto;
import com.codestates.StackOverFlowClone.question.dto.QuestionPostDto;
import com.codestates.StackOverFlowClone.question.dto.QuestionResponseDto;
import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.question.service.QuestionService;
import com.codestates.StackOverFlowClone.question.mapper.QuestionMapper;
import com.codestates.StackOverFlowClone.response.MultiResponseDto;
import com.codestates.StackOverFlowClone.utils.UriCreator;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
@Validated
public class QuestionController {

    private final static String QUESTION_DEFAULT_URL = "/question";
    private final QuestionService questionService;
    private final QuestionMapper mapper;

    public QuestionController(QuestionService questionService, QuestionMapper mapper){
        this.questionService = questionService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionPostDto requestBody){

        Question questionmapper = mapper.questionPostDtoToQuestion(requestBody);

        Question question = questionService.createQuestion(questionmapper);

        URI location = UriCreator.createUri(QUESTION_DEFAULT_URL, question.getQuestionId());

        return ResponseEntity.created(location).body(mapper.questionToQuestionResponseDto(question));

    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive long questionId,
                                       @Valid @RequestBody QuestionPatchDto requestBody){

        requestBody.setQuestionId(questionId);

        Question question = mapper.questionPatchDtoToQuestion(requestBody);

        Question response = questionService.updateQuestion(question);

        return new ResponseEntity<>(
                mapper.questionToQuestionResponseDto(response)
                , HttpStatus.OK);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") @Positive long questionId){

        Question response = questionService.findQuestion(questionId);

        return new ResponseEntity<>(
                mapper.questionToQuestionResponseDto(response)
                , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size){

        Page<Question> pageQuestions = questionService.findQuestions(page - 1, size);

        List<Question> questions = pageQuestions.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.questionsToQuestionResponseDtos(questions),
                        pageQuestions),
                HttpStatus.OK);

    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive long questionId){

        questionService.deleteQuestion(questionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
