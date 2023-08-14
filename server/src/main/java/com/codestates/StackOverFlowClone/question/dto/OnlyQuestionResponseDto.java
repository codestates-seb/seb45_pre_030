package com.codestates.StackOverFlowClone.question.dto;


import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OnlyQuestionResponseDto {

    private long questionId;

    private String title;

    private long memberId;

    private String content;

    private LocalDateTime createdAt;

    private long viewCount;

}
