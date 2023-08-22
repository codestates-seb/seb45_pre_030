package com.codestates.StackOverFlowClone.comment.dto;

import lombok.Getter;
import lombok.Setter;

public class CommentDto {
    @Getter
    @Setter
    public static class Post {
        private long commentId;
        private long replyId;
        private long memberId;
        private String name;
        private String content;

        public Post(long commentId, long replyId, long memberId, String name, String content) {
            this.commentId = commentId;
            this.replyId = replyId;
            this.memberId = memberId;
            this.name = name;
            this.content = content;
        }
    }
    @Getter
    @Setter
    public static class Patch {
        private long commentId;
        private long replyId;
        private long memberId;
        private String name;
        private String content;
    }
}
