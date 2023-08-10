package com.codestates.StackOverFlowClone.reply.mapper;

import com.codestates.StackOverFlowClone.reply.dto.ReplyPatchDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyPostDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyResponseDto;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReplyMapper {
    Reply ReplyPostDtoToReply(ReplyPostDto replyPostDto);
    Reply ReplyPatchDtoToReply(ReplyPatchDto replyPatchDto);
    ReplyResponseDto ReplyToReplyResponseDto(Reply reply);
    List<ReplyResponseDto> RepliesToReplyResponseDtos(List<Reply> replies);
}
