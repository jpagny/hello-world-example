package com.demo.domain.core.greeting.ports.input;

import com.demo.domain.core.greeting.operations.queries.GetGreetingQuery;
import com.demo.domain.core.greeting.operations.results.GetGreetingResult;

public interface GetGreetingUseCase {
    GetGreetingResult handle(GetGreetingQuery query);
}