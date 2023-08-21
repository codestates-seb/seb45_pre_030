package com.codestates.StackOverFlowClone.advice;

import com.codestates.StackOverFlowClone.exception.BusinessLogicException;
import com.codestates.StackOverFlowClone.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler
    public ErrorResponse handleBusinessLogicException(BusinessLogicException e) {
        return ErrorResponse.of(e.getExceptionCode());
    }

}
