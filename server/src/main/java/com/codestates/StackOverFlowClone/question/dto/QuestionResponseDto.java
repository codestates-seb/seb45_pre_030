package com.codestates.StackOverFlowClone.question.dto;


import com.codestates.StackOverFlowClone.reply.dto.ReplyResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class QuestionResponseDto {

    private long questionId;
    private long memberId;

    private String title;

    private String writer;

    private String content;

    private LocalDateTime  createdAt;
    private List<ReplyResponseDto> replies;

    private long replyChoice;

}
