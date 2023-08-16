package com.codestates.StackOverFlowClone.question.mapper;


import com.codestates.StackOverFlowClone.comment.dto.CommentResponseDto;
import com.codestates.StackOverFlowClone.comment.entity.Comment;
import com.codestates.StackOverFlowClone.question.dto.QuestionDto;
import com.codestates.StackOverFlowClone.question.dto.OnlyQuestionResponseDto;
import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.reply.dto.ReplyResponseDto;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostDtoToQuestion(QuestionDto.Post questionPostDto);
    Question questionPatchDtoToQuestion(QuestionDto.Patch questionPatchDto);

    default QuestionDto.Response questionToQuestionResponseDto(Question question) {
        OnlyQuestionResponseDto onlyQuestionResponseDto =
                OnlyQuestionResponseDto.builder()
                        .questionId(question.getQuestionId())
                        .memberId(question.getMemberId())
                        .title(question.getTitle())
                        .content(question.getContent())
                        .createdAt(question.getCreatedAt())
                        .viewCount(question.getViewCount())
                        .build();
        List<ReplyResponseDto> replyResponseDtos = new ArrayList<>();

        if(question.getReplies() != null) {
            for(Reply reply : question.getReplies()) {
                ReplyResponseDto replyResponseDto =
                        ReplyResponseDto.builder()
                                .replyId(reply.getReplyId())
                                .questionId(reply.getQuestion().getQuestionId())
                                .memberId(reply.getMemberId())
                                .content(reply.getContent())
                                .createdAt(reply.getCreatedAt())
                                .build();

                List<CommentResponseDto> commentResponseDtos = new ArrayList<>();

                if(reply.getComments() != null){
                    for(Comment comment : reply.getComments()){
                        CommentResponseDto commentResponseDto =
                                CommentResponseDto.builder()
                                        .commentId(comment.getCommentId())
                                        .content(comment.getContent())
                                        .createdAt(comment.getCreatedAt())
                                        .replyId(comment.getReply().getReplyId())
                                        .build();

                        commentResponseDtos.add(commentResponseDto);
                    }
                }

                replyResponseDto.setComments(commentResponseDtos);

                replyResponseDtos.add(replyResponseDto);
            }

        }
        return new QuestionDto.Response(onlyQuestionResponseDto, replyResponseDtos);
    }

    OnlyQuestionResponseDto questionToOnlyQuestionResponseDto(Question question);

    List<OnlyQuestionResponseDto> questionsToOnlyQuestionResponseDtos(List<Question> questions);

}
