package com.codestates.StackOverFlowClone.reply.mapper;

import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.reply.dto.ReplyDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyPatchDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyPostDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyResponseDto;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Mapper(componentModel = "spring")
public interface ReplyMapper {

    @Mapping(source = "questionId", target = "question.questionId")
    Reply ReplyPostDtoToReply(ReplyDto.Post replyPostDto);
    @Mapping(source = "questionId", target = "question.questionId")
    Reply ReplyPatchDtoToReply(ReplyDto.Patch replyPatchDto);
    @Mapping(source = "question.questionId", target = "questionId")
    ReplyResponseDto ReplyToReplyResponseDto(Reply reply);
    List<ReplyResponseDto> RepliesToReplyResponseDtos(List<Reply> replies);

/*
    @Override
    default public Reply ReplyPostDtoToReply(ReplyDto.Post replyPostDto) {
        if ( replyPostDto == null ) {
            return null;
        }

        Reply reply = new Reply();

        reply.setQuestion( postToQuestion( replyPostDto ) );
        reply.setMemberId( replyPostDto.getMemberId() );
        reply.setContent( replyPostDto.getContent() );

        return reply;
    }


    default public Reply ReplyPatchDtoToReply(ReplyDto.Patch replyPatchDto) {
        if ( replyPatchDto == null ) {
            return null;
        }

        Reply reply = new Reply();

        reply.setQuestion( patchToQuestion( replyPatchDto ) );
        reply.setReplyId( replyPatchDto.getReplyId() );
        reply.setMemberId( replyPatchDto.getMemberId() );
        reply.setContent( replyPatchDto.getContent() );

        return reply;
    }


    default public ReplyResponseDto ReplyToReplyResponseDto(Reply reply) {
        if ( reply == null ) {
            return null;
        }

        ReplyResponseDto.ReplyResponseDtoBuilder replyResponseDto = ReplyResponseDto.builder();

        replyResponseDto.questionId( replyQuestionQuestionId( reply ) );
        replyResponseDto.replyId( reply.getReplyId() );
        replyResponseDto.memberId( reply.getMemberId() );
        replyResponseDto.content( reply.getContent() );
        replyResponseDto.createdAt( reply.getCreatedAt() );

        return replyResponseDto.build();
    }

    public List<ReplyResponseDto> RepliesToReplyResponseDtos(List<Reply> replies) {
        if ( replies == null ) {
            return null;
        }

        List<ReplyResponseDto> list = new ArrayList<ReplyResponseDto>( replies.size() );
        for ( Reply reply : replies ) {
            list.add( ReplyToReplyResponseDto( reply ) );
        }

        return list;
    }

    protected Question postToQuestion(ReplyDto.Post post) {
        if ( post == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( post.getQuestionId() );

        return question;
    }

    protected Question patchToQuestion(ReplyDto.Patch patch) {
        if ( patch == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( patch.getQuestionId() );

        return question;
    }

    private long replyQuestionQuestionId(Reply reply) {
        if ( reply == null ) {
            return 0L;
        }
        Question question = reply.getQuestion();
        if ( question == null ) {
            return 0L;
        }
        long questionId = question.getQuestionId();
        return questionId;
    }
    */

}
