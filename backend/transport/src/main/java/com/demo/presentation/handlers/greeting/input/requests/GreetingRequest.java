package com.demo.presentation.handlers.greeting.input.requests;

import java.time.Instant;

public record GreetingRequest(
        String locale,
        String level,
        String context,
        String name,
        String timeZone,
        Instant at
) {}
