package com.demo.domain.core.greeting.exceptions;

import com.demo.domain.commons.exceptions.engine.BaseBusinessException;
import com.demo.domain.commons.exceptions.engine.IBusinessError;

public class GreetingDomainException extends BaseBusinessException {

    public GreetingDomainException(IBusinessError businessError, Object... args) {
        super(businessError, args);
    }

    public static GreetingDomainException invalidQuery(Object... args) {
        return new GreetingDomainException(GreetingBusinessError.INVALID_QUERY, args);
    }

    public static GreetingDomainException missingLexiconEntry(Object... args) {
        return new GreetingDomainException(GreetingBusinessError.MISSING_LEXICON_ENTRY, args);
    }

}
