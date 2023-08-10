package com.codestates.StackOverFlowClone.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionPatchDto {

    @NotNull
    private long questionId;

    @Size(max = 100)
    private String questionTitle;

    @Size(max = 1000)
    private String questionContent;

    private long questionReplyLimitCount;


}
