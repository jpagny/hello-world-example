package com.demo.domain.core.greeting.models;

import com.demo.domain.core.greeting.enums.LanguageLevel;

public record Greeting(
        String base,
        String name,
        LanguageLevel level,
        GreetingContextKey context,
        LocaleTag locale
) {

}
