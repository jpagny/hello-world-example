package com.demo.presentation.common.i18n;

import com.demo.domain.commons.exceptions.engine.IBusinessError;

import java.util.Locale;

public interface BusinessErrorMessageResolver {
    String resolve(IBusinessError error, Locale locale, Object... args);
}
