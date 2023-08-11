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

    public QuestionPostDto(String questionTitle, String questionWriter, String questionContent) {
        this.questionTitle = questionTitle;
        this.questionWriter = questionWriter;
        this.questionContent = questionContent;
    }

}
