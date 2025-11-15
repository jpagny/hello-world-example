package com.demo.domain.commons.exceptions.engine;

import com.demo.domain.commons.exceptions.codes.ErrorCode;

public interface IBusinessError {
    ErrorCode code();

    default String nameKey() {
        return ((Enum<?>) this).name();
    }
}

