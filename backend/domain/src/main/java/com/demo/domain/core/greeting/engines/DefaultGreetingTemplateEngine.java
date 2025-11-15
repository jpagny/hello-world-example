package com.demo.domain.core.greeting.engines;

import com.demo.domain.core.greeting.enums.LanguageLevel;
import com.demo.domain.core.greeting.messages.GreetingMessageKey;

public final class DefaultGreetingTemplateEngine implements GreetingTemplateEngine {

    @Override
    public GreetingMessageKey choose(LanguageLevel level, boolean withName) {
        if (!withName) {
            return GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_BASE_ONLY;
        }
        return (level == LanguageLevel.INFORMAL)
                ? GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_NAME_THEN_BASE_FRIENDLY
                : GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_BASE_WITH_NAME;
    }
}
