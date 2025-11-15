package com.demo.domain.core.greeting.messages;

public enum GreetingMessageKey {

    /** Standard greeting → "{0}, {1}!" */
    MESSAGE_GREETING_TEMPLATE_BASE_WITH_NAME,

    /** Greeting without a name → "{0}!" */
    MESSAGE_GREETING_TEMPLATE_BASE_ONLY,

    /** Friendly or informal greeting → "Hey {1}, {0}!" */
    MESSAGE_GREETING_TEMPLATE_NAME_THEN_BASE_FRIENDLY
}
