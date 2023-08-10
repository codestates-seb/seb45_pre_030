package com.codestates.StackOverFlowClone.reply.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
@Getter
public class ReplyPatchDto {

    private long replyId;

    @NotBlank
    private String content;

    public void setReplyId(long replyId) { this.replyId = replyId; }
}
