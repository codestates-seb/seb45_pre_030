package com.codestates.StackOverFlowClone.reply.mapper;

import com.codestates.StackOverFlowClone.reply.dto.ReplyPatchDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyPostDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyResponseDto;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReplyMapper {

    Reply ReplyPostDtoToReply(ReplyPostDto replyPostDto);
    Reply ReplyPatchDtoToReply(ReplyPatchDto replyPatchDto);
    ReplyResponseDto ReplyToReplyResponseDto(Reply reply);
    List<ReplyResponseDto> RepliesToReplyResponseDtos(List<Reply> replies);
/*
    @Override
    public Reply ReplyPostDtoToReply(ReplyPostDto replyPostDto) {
        if ( replyPostDto == null ) {
            return null;
        }

        Reply reply = new Reply();

        reply.setQuestionId( replyPostDto.getQuestionId() );
        reply.setMemberId( replyPostDto.getMemberId() );
        reply.setContent( replyPostDto.getContent() );

        return reply;
    }

    @Override
    public Reply ReplyPatchDtoToReply(ReplyPatchDto replyPatchDto) {
        if ( replyPatchDto == null ) {
            return null;
        }

        Reply reply = new Reply();

        reply.setReplyId( replyPatchDto.getReplyId() );
        reply.setContent( replyPatchDto.getContent() );

        return reply;
    }

    @Override
    public ReplyResponseDto ReplyToReplyResponseDto(Reply reply) {
        if ( reply == null ) {
            return null;
        }

        ReplyResponseDto replyResponseDto = new ReplyResponseDto();

        replyResponseDto.setReplyId( reply.getReplyId() );
        replyResponseDto.setQuestionId( reply.getQuestionId() );
        replyResponseDto.setMemberId( reply.getMemberId() );
        replyResponseDto.setContent( reply.getContent() );
        replyResponseDto.setReplyDttm( reply.getReplyDttm() );

        return replyResponseDto;
    }

    @Override
    public List<ReplyResponseDto> RepliesToReplyResponseDtos(List<Reply> replies) {
        if ( replies == null ) {
            return null;
        }

        List<ReplyResponseDto> list = new ArrayList<ReplyResponseDto>( replies.size() );
        for ( Reply reply : replies ) {
            list.add( ReplyToReplyResponseDto( reply ) );
        }

        return list;
    }*/
}
