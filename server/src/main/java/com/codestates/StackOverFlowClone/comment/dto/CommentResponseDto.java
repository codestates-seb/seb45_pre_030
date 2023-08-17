package com.codestates.StackOverFlowClone.comment.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDto {
    private long commentId;
    private long replyId;
    //    private Member member;
    private long memberId;
    private String content;

    private LocalDateTime createdAt;
}
