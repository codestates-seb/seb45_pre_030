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
public class ReplyPatchDto {

    private long replyId;

    private long questionId;

    private long memberId;

    @NotBlank
    private String content;

}
