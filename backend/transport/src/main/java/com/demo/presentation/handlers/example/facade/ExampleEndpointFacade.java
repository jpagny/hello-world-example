package com.demo.presentation.handlers.example.facade;

import com.demo.presentation.common.contracts.InputPresenter;
import com.demo.presentation.common.contracts.OutputPresenter;
import com.demo.application.services.example.ExampleService;
import com.demo.presentation.handlers.example.input.requests.CreateExampleRequest;
import com.demo.presentation.handlers.example.output.responses.CreateExampleResponse;
import com.demo.domain.core.example.operations.commands.CreateExampleCommand;
import com.demo.domain.core.example.operations.results.CreateExampleResult;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExampleEndpointFacade {

    private final InputPresenter<CreateExampleRequest, CreateExampleCommand> inPresenter;
    private final OutputPresenter<CreateExampleResult, CreateExampleResponse> outPresenter;
    private final ExampleService app;

    public CreateExampleResponse create(CreateExampleRequest req) {
        var cmd = inPresenter.toCommand(req);
        var result = app.create(cmd);
        return outPresenter.toResponse(result);
    }
}
