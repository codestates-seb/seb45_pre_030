package com.codestates.StackOverFlowClone.reply.dto;

import java.time.LocalDateTime;

public class OneReplyResponse {
    private long replyId;
    private long questionId;
    private long memberId;
    private String content;
    private LocalDateTime createdAt;
    private long choice;

}
