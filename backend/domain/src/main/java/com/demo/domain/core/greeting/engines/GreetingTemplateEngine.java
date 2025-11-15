package com.demo.domain.core.greeting.engines;

import com.demo.domain.core.greeting.enums.LanguageLevel;
import com.demo.domain.core.greeting.messages.GreetingMessageKey;

public interface GreetingTemplateEngine {
    GreetingMessageKey choose(LanguageLevel level, boolean withName);
}
