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



}
