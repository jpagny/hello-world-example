package com.demo.domain.commons.exceptions.engine;

import com.demo.domain.commons.exceptions.codes.ErrorCode;

public interface IBaseException {
    ErrorCode getCode();
    IBusinessError getBusinessError();
    String getBusinessCode();
    Object[] getArgs();
}
