package com.demo.application.services.example;

import com.demo.domain.core.example.operations.commands.CreateExampleCommand;
import com.demo.domain.core.example.operations.results.CreateExampleResult;

public interface ExampleService {
    CreateExampleResult create(CreateExampleCommand command);
}
