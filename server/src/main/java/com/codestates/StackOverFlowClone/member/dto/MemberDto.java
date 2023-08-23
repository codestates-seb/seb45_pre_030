package com.codestates.StackOverFlowClone.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String password;

        @NotBlank
        private String confirmPassword;

        @NotBlank(message = "이름은 공백이 아니어야 합니다.")
        private String name;
    }
    @Getter
    @AllArgsConstructor
    public static class Patch {
        private long memberId;

        private String name;

        private String password;

        private String confirmPassword;

        public void setMemberId(long memberId) {
            this.memberId = memberId;
        }
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private long memberId;
        private String email;
        private String name;
        private String password;

    }

}
