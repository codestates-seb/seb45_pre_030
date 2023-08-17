package com.codestates.StackOverFlowClone.question.dto;

import com.codestates.StackOverFlowClone.reply.dto.ReplyResponseDto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class QuestionDto {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Post {
        @Size(max = 100)
        private String title;


        private long memberId;

        @Size(max = 1000)
        private String content;

        public Post(String title, long memberId, String content) {
            this.title = title;
            this.memberId = memberId;
            this.content = content;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Patch {

        private long questionId;

        @Size(max = 100)
        private String title;

        @Size(max = 1000)
        private String content;

        private long memberId;

        private Long viewCount;

    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private OnlyQuestionResponseDto question;
        private List<ReplyResponseDto> replies;
    }
}
