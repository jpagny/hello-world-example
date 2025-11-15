package com.demo.domain.core.example.exceptions;

import com.demo.domain.commons.exceptions.codes.ErrorCode;
import com.demo.domain.commons.exceptions.engine.ErrorContext;
import com.demo.domain.commons.exceptions.engine.IBusinessError;

@ErrorContext("example")
public enum ExampleBusinessError implements IBusinessError {

    INVALID_NAME(ErrorCode.INVALID_INPUT),
    ALREADY_EXISTS(ErrorCode.DUPLICATE_RESOURCE),
    FORBIDDEN_NAME(ErrorCode.INVALID_INPUT),
    NOT_FOUND(ErrorCode.RESOURCE_NOT_FOUND);

    private final ErrorCode code;

    ExampleBusinessError(ErrorCode code) {
        this.code = code;
    }
    @Override public ErrorCode code() { return code; }
}