package com.demo.domain.core.greeting.exceptions;

import com.demo.domain.commons.exceptions.codes.ErrorCode;
import com.demo.domain.commons.exceptions.engine.ErrorContext;
import com.demo.domain.commons.exceptions.engine.IBusinessError;

@ErrorContext("greeting")
public enum GreetingBusinessError implements IBusinessError {

    INVALID_QUERY(ErrorCode.PRECONDITION_FAILED),
    MISSING_LEXICON_ENTRY(ErrorCode.RESOURCE_NOT_FOUND);

    private final ErrorCode code;

    GreetingBusinessError(ErrorCode code) {
        this.code = code;
    }
    @Override public ErrorCode code() { return code; }
}