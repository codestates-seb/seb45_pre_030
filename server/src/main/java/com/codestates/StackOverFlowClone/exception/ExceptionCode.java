package com.codestates.StackOverFlowClone.exception;

import lombok.Getter;

public enum ExceptionCode {

    UNAUTHORIZED(401,  "수정/삭제는 본인만 가능합니다.");

    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
