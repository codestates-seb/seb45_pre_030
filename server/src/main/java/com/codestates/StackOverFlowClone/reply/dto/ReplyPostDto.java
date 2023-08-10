package com.codestates.StackOverFlowClone.reply.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
@Getter
public class ReplyPostDto {
    private long questionId;

    private long memberId;

    @NotBlank
    private String content;

    public void addQuestionId(long questionId) { this.questionId = questionId; }

    public void addMemberId(long memberId) { this.memberId = memberId; }
}
