package com.codestates.StackOverFlowClone.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyPostDto {
    private long questionId;

    private long memberId;

    @NotBlank
    private String content;

    public void addQuestionId(long questionId) { this.questionId = questionId; }

    public void addMemberId(long memberId) { this.memberId = memberId; }
}
