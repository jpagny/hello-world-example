package com.demo.presentation.common.errors.http;

import com.demo.domain.commons.exceptions.codes.ErrorCode;
import org.springframework.http.HttpStatus;

public interface ErrorCodeToHttpStatusResolver {
    HttpStatus resolve(ErrorCode code);
}
