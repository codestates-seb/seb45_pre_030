package com.codestates.StackOverFlowClone.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class ReplyDto {
    @Getter
    @Setter
    public static class Post {
        private long questionId;

        private long memberId;

        @NotBlank
        private String content;


    }

    @Getter
    @Setter
    public static class Patch {
        private long replyId;

        private long questionId;

        private long memberId;

        @NotBlank
        private String content;
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private long replyId;
        private long questionId;
        private long memberId;
        private String content;
        private LocalDateTime createdAt;
    }
}
