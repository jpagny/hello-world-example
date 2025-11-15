package com.demo.application.services.greeting.impl;

import com.demo.application.services.greeting.GreetingService;
import com.demo.domain.core.greeting.operations.queries.GetGreetingQuery;
import com.demo.domain.core.greeting.operations.results.GetGreetingResult;
import com.demo.domain.core.greeting.ports.input.GetGreetingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class GreetingServiceImpl implements GreetingService {

    private final GetGreetingUseCase useCase;

    @Override
    @Transactional(readOnly = true)
    public GetGreetingResult process(GetGreetingQuery query) {
        return useCase.handle(query);
    }
}
