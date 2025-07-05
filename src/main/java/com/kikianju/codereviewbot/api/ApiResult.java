package com.kikianju.codereviewbot.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor

public class ApiResult<T> {
    private String result;         // success or fail
    private String message;        // 설명 메시지
    private LocalDateTime time;    // 응답 시간
    private T data;                // 응답 데이터
}
