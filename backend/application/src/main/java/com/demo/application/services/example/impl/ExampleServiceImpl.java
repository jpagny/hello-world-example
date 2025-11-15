package com.demo.application.services.example.impl;

import com.demo.application.services.example.ExampleService;
import com.demo.domain.core.example.operations.commands.CreateExampleCommand;
import com.demo.domain.core.example.operations.results.CreateExampleResult;
import com.demo.domain.core.example.ports.input.CreateExampleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExampleServiceImpl implements ExampleService {

    private final CreateExampleUseCase useCase;

    @Override
    @Transactional
    public CreateExampleResult create(CreateExampleCommand command) {
        return useCase.handle(command);
    }
}
