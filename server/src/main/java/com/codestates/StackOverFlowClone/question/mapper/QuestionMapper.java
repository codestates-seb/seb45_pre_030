package com.codestates.StackOverFlowClone.question.mapper;


import com.codestates.StackOverFlowClone.question.dto.QuestionPatchDto;
import com.codestates.StackOverFlowClone.question.dto.QuestionPostDto;
import com.codestates.StackOverFlowClone.question.dto.QuestionResponseDto;
import com.codestates.StackOverFlowClone.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    QuestionResponseDto questionToQuestionResponseDto(Question question);

    List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions);

}

/*
    @Override
    public Question questionPostDtoToQuestion(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionTitle( questionPostDto.getQuestionTitle() );
        question.setQuestionWriter( questionPostDto.getQuestionWriter() );
        question.setQuestionContent( questionPostDto.getQuestionContent() );
        question.setQuestionReplyLimitCount( questionPostDto.getQuestionReplyLimitCount() );

        return question;
    }

    @Override
    public Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto) {
        if ( questionPatchDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionPatchDto.getQuestionId() );
        question.setQuestionTitle( questionPatchDto.getQuestionTitle() );
        question.setQuestionContent( questionPatchDto.getQuestionContent() );
        question.setQuestionReplyLimitCount( questionPatchDto.getQuestionReplyLimitCount() );

        return question;
    }

    @Override
    public QuestionResponseDto questionToQuestionResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionResponseDto questionResponseDto = new QuestionResponseDto();

        questionResponseDto.setQuestionId( question.getQuestionId() );
        questionResponseDto.setQuestionTitle( question.getQuestionTitle() );
        questionResponseDto.setQuestionWriter( question.getQuestionWriter() );
        questionResponseDto.setQuestionContent( question.getQuestionContent() );
        questionResponseDto.setQuestionDttm( question.getQuestionDttm() );
        questionResponseDto.setQuestionReplyLimitCount( question.getQuestionReplyLimitCount() );

        return questionResponseDto;
    }

    @Override
    public List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionResponseDto> list = new ArrayList<QuestionResponseDto>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToQuestionResponseDto( question ) );
        }

        return list;
    }*/
