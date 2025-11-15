package com.demo.presentation.common.errors.http.impl;

import com.demo.presentation.common.errors.http.ErrorCodeToHttpStatusResolver;
import com.demo.domain.commons.exceptions.codes.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class DefaultErrorCodeToHttpStatusResolverImpl implements ErrorCodeToHttpStatusResolver {

    private static final Map<ErrorCode, HttpStatus> MAP = new EnumMap<>(ErrorCode.class);

    static {
        MAP.put(ErrorCode.INVALID_INPUT,       HttpStatus.BAD_REQUEST);
        MAP.put(ErrorCode.MISSING_INPUT,       HttpStatus.BAD_REQUEST);
        MAP.put(ErrorCode.EMPTY_INPUT,         HttpStatus.BAD_REQUEST);
        MAP.put(ErrorCode.RESOURCE_NOT_FOUND,  HttpStatus.NOT_FOUND);
        MAP.put(ErrorCode.DUPLICATE_RESOURCE,  HttpStatus.CONFLICT);
        MAP.put(ErrorCode.PERMISSION_DENIED,   HttpStatus.FORBIDDEN);
        MAP.put(ErrorCode.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED);
        MAP.put(ErrorCode.OPERATION_FAILED,    HttpStatus.UNPROCESSABLE_ENTITY);
        MAP.put(ErrorCode.SYSTEM_FAILURE,      HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public DefaultErrorCodeToHttpStatusResolverImpl() {
    }

    @Override
    public HttpStatus resolve(ErrorCode code) {
        if (code == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return MAP.getOrDefault(code, HttpStatus.BAD_REQUEST);
    }
}
