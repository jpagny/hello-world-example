package com.demo.presentation.handlers.greeting.handle;

import com.demo.application.services.greeting.GreetingService;
import com.demo.domain.core.greeting.operations.queries.GetGreetingQuery;
import com.demo.domain.core.greeting.operations.results.GetGreetingResult;
import com.demo.presentation.common.contracts.InputPresenter;
import com.demo.presentation.common.contracts.OutputPresenter;
import com.demo.presentation.handlers.greeting.input.requests.GreetingRequest;
import com.demo.presentation.handlers.greeting.output.responses.GreetingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GreetingEndpointHandler {

    private final InputPresenter<GreetingRequest, GetGreetingQuery> inPresenter;
    private final OutputPresenter<GetGreetingResult, GreetingResponse> outPresenter;
    private final GreetingService app;

    public GreetingResponse present(GreetingRequest req) {
        var query  = inPresenter.toCommand(req);
        var result = app.process(query);
        return outPresenter.toResponse(result);
    }
}
