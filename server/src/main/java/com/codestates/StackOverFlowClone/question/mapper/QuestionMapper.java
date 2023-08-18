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

    OnlyQuestionResponseDto questionToOnlyQuestionResponseDto(Question question);

    List<OnlyQuestionResponseDto> questionsToOnlyQuestionResponseDtos(List<Question> questions);

    default QuestionDto.Response questionToQuestionResponseDto(Question question) {

        OnlyQuestionResponseDto onlyQuestionResponseDto = questionToOnlyQuestionResponseDto(question);
        List<ReplyResponseDto> replyResponseDtos = getRepliesResponseDto(question);

        return new QuestionDto.Response(onlyQuestionResponseDto, replyResponseDtos);
    }
    default List<ReplyResponseDto> getRepliesResponseDto(Question question) {
        List<ReplyResponseDto> replyResponseDtos = new ArrayList<>();
        List<Reply> replies =  question.getReplies();
        if(replies != null) {
            for (Reply reply : replies) {
                ReplyResponseDto replyResponseDto =
                        ReplyResponseDto.builder()
                                .replyId(reply.getReplyId())
                                .questionId(reply.getQuestion().getQuestionId())
                                .memberId(reply.getMemberId())
                                .content(reply.getContent())
                                .createdAt(reply.getCreatedAt())
                                .comments(getCommentsResponseDto(reply))
                                .build();
                replyResponseDtos.add(replyResponseDto);
            }
        }
        return replyResponseDtos;
    }

    default List<CommentResponseDto> getCommentsResponseDto(Reply reply) {
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        List<Comment> comments = reply.getComments();
        if(comments != null) {
            for (Comment comment : comments) {
                CommentResponseDto commentResponseDto =
                        CommentResponseDto.builder()
                                .commentId(comment.getCommentId())
                                .content(comment.getContent())
                                .memberId(comment.getMemberId())
                                .createdAt(comment.getCreatedAt())
                                .replyId(comment.getReply().getReplyId())
                                .build();

                commentResponseDtos.add(commentResponseDto);
            }
        }
            return commentResponseDtos;
    }
}

