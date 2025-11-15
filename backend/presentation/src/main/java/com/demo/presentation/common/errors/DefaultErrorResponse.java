package com.demo.presentation.common.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DefaultErrorResponse(
        String business,
        String code,
        String message,
        Integer status,
        String path,
        String traceId,
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        Instant timestamp
) {
    public static DefaultErrorResponse of(String code, String message) {
        return new DefaultErrorResponse(null, code, message, null, null, null, Instant.now());
    }

    public static DefaultErrorResponse of(String business, String code, String message, int status, String path, String traceId) {
        return new DefaultErrorResponse(business, code, message, status, path, traceId, Instant.now());
    }
}
