package com.codestates.StackOverFlowClone.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class CommentDto {
    @Getter
    @Setter
    public static class Post {
        private long commentId;
        private long replyId;
        private long memberId;
        private String content;
    }
    @Getter
    @Setter
    public static class Patch {
        private long commentId;
        private long replyId;
        private long memberId;
        private String content;
    }
    @Getter
    @NoArgsConstructor
    public static class Response {
        private long commentId;
        private long replyId;
        private long memberId;
        private String content;
        private LocalDateTime createdAt;

    }
}
