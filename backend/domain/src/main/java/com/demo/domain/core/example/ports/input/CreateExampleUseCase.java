package com.demo.domain.core.example.ports.input;

import com.demo.domain.core.example.operations.commands.CreateExampleCommand;
import com.demo.domain.core.example.operations.results.CreateExampleResult;

public interface CreateExampleUseCase {
    CreateExampleResult handle(CreateExampleCommand command);
}
