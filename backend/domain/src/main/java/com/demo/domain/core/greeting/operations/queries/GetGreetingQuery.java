package com.demo.domain.core.greeting.operations.queries;

import com.demo.domain.core.greeting.enums.LanguageLevel;
import com.demo.domain.core.greeting.models.GreetingContextKey;
import com.demo.domain.core.greeting.models.LocaleTag;

public record GetGreetingQuery(
        LocaleTag locale,
        LanguageLevel level,
        GreetingContextKey context,
        String name
) {
    public boolean hasName() {
        return name != null && !name.isBlank();
    }
}