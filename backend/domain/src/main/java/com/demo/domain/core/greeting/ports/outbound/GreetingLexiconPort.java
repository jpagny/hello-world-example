package com.demo.domain.core.greeting.ports.outbound;

import com.demo.domain.core.greeting.enums.LanguageLevel;
import com.demo.domain.core.greeting.models.Greeting;
import com.demo.domain.core.greeting.models.GreetingContextKey;
import com.demo.domain.core.greeting.models.LocaleTag;

import java.util.Optional;

public interface GreetingLexiconPort {
    Optional<Greeting> load(LocaleTag locale, LanguageLevel level, GreetingContextKey context);
}
