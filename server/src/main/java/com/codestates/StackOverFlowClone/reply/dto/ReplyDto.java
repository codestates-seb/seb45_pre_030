package com.codestates.StackOverFlowClone.reply.dto;

import com.codestates.StackOverFlowClone.comment.dto.CommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ReplyDto {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post {
        private long questionId;

        private long memberId;

        @NotBlank
        private String content;


    }

    @Getter
    @Setter
    @AllArgsConstructor
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
        OneReplyResponse oneReply;
        List<CommentResponseDto> comments;
    }
}
