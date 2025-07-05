package com.kikianju.codereviewbot.api;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice  // ✅ 모든 컨트롤러의 예외를 처리해주는 글로벌 핸들러
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResult<Object> handle(Exception e) {
        return ApiResult.builder()
                .result("fail")
                .message(e.getMessage())
                .time(LocalDateTime.now())
                .data(null)
                .build();
    }
}
