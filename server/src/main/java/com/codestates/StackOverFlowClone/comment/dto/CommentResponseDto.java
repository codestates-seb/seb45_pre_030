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
    private long memberId;
    private String memberName;
    private String content;

    private LocalDateTime createdAt;
}
