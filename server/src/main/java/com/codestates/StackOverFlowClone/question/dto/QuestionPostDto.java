package com.codestates.StackOverFlowClone.question.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class QuestionPostDto {

    @Size(max = 100)
    private String title;

    @Size(max = 20)
    private long memberId;

    @Size(max = 1000)
    private String content;

    public QuestionPostDto(String title, long memberId, String content) {
        this.title = title;
        this.memberId = memberId;
        this.content = content;
    }

}
