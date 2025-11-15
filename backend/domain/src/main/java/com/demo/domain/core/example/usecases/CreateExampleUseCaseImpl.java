package com.demo.domain.core.example.usecases;

import com.demo.domain.core.example.exceptions.ExampleDomainException;
import com.demo.domain.core.example.messages.ExampleMessageKey;
import com.demo.domain.core.example.operations.commands.CreateExampleCommand;
import com.demo.domain.core.example.operations.results.CreateExampleResult;
import com.demo.domain.core.example.ports.input.CreateExampleUseCase;

public class CreateExampleUseCaseImpl implements CreateExampleUseCase {

    @Override
    public CreateExampleResult handle(CreateExampleCommand command) {
        final String name = command.name();

        if (name.length() < 3) {
            throw ExampleDomainException.invalidName(name);
        }
        if ("duplicate".equalsIgnoreCase(name)) {
            throw ExampleDomainException.alreadyExists(name);
        }
        if ("forbidden".equalsIgnoreCase(name)) {
            throw ExampleDomainException.forbiddenName();
        }

        var id = 1L;
        return new CreateExampleResult(id, ExampleMessageKey.EXAMPLE_CREATED, name);
    }
}
