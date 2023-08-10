package com.codestates.StackOverFlowClone.question.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class QuestionResponseDto {

    private long questionId;

    private String questionTitle;

    private String questionWriter;

    private String questionContent;

    private LocalDateTime questionDateTime;

}
