package com.codestates.StackOverFlowClone.question.dto;

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
public class QuestionPostDto {

    @Size(max = 100)
    private String questionTitle;

    @Size(max = 20)
    private String questionWriter;

    @Size(max = 1000)
    private String questionContent;

    private long questionReplyLimitCount;

    public QuestionPostDto(String questionTitle, String questionWriter, String questionContent, long questionReplyLimitCount) {
        this.questionTitle = questionTitle;
        this.questionWriter = questionWriter;
        this.questionContent = questionContent;
        this.questionReplyLimitCount = questionReplyLimitCount;
    }

}
