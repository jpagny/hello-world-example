package com.demo.domain.core.greeting.operations.results;

import com.demo.domain.core.greeting.messages.GreetingMessageKey;
import com.demo.domain.core.greeting.models.Greeting;

public record GetGreetingResult(
        GreetingMessageKey messageKey,
        Greeting greeting
) {

}