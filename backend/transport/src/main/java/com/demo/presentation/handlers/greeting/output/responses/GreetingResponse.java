package com.demo.presentation.handlers.greeting.output.responses;

public record GreetingResponse(
        String message,
        String base,
        String name,
        String level,
        String context,
        String locale
) {}
