package com.codestates.StackOverFlowClone.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyResponseDto {
    private long replyId;
    private long questionId;
    private long memberId;
    private String content;
    private LocalDateTime replyDateTime;

}
