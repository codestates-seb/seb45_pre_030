package com.codestates.StackOverFlowClone.question.exception;

import lombok.Getter;

public enum ExceptionCode {
    NOT_FOUND(404, "not found"),
    EXISTS(409, "exists");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
