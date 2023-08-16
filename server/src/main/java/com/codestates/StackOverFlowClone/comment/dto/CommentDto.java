package com.codestates.StackOverFlowClone.comment.dto;

import com.codestates.StackOverFlowClone.comment.entity.Comment;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;


public class CommentDto {
    @Getter
    @Setter
    public static class Post {
        private long commentId;
        private long replyId;
        private String content;
    }
    @Getter
    @Setter
    public static class Patch {
        private long commentId;
        private long replyId;
        private String content;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private long commentId;
        private long replyId;
        private String content;
        private LocalDateTime createdAt;

    }
}
