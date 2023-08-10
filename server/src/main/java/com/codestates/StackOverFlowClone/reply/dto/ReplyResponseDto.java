package com.codestates.StackOverFlowClone.reply.dto;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ReplyResponseDto {
    private long replyId;
    private long questionId;
    private long memberId;
    private String content;
    private LocalDateTime replyDttm;

}
