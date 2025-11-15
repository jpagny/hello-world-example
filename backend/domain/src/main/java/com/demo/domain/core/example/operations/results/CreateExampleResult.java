package com.demo.domain.core.example.operations.results;

import com.demo.domain.core.example.messages.ExampleMessageKey;

public record CreateExampleResult(Long id, ExampleMessageKey messageKey, String name) { }
