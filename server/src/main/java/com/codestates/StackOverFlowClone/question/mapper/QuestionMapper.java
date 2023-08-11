package com.codestates.StackOverFlowClone.question.mapper;


import com.codestates.StackOverFlowClone.question.dto.QuestionPatchDto;
import com.codestates.StackOverFlowClone.question.dto.QuestionPostDto;
import com.codestates.StackOverFlowClone.question.dto.QuestionResponseDto;
import com.codestates.StackOverFlowClone.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    QuestionResponseDto questionToQuestionResponseDto(Question question);

    List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions);

}


