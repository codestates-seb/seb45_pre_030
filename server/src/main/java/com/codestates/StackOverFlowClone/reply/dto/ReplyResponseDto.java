package com.codestates.StackOverFlowClone.reply.dto;

import com.codestates.StackOverFlowClone.comment.dto.CommentResponseDto;
import com.codestates.StackOverFlowClone.comment.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyResponseDto {

    private long replyId;
    private long questionId;
    private long memberId;
    private String content;
    private LocalDateTime createdAt;
    private List<CommentResponseDto> comments;
    private long choice;

}
