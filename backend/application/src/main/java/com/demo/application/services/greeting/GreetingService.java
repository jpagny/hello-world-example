package com.demo.application.services.greeting;

import com.demo.domain.core.greeting.operations.queries.GetGreetingQuery;
import com.demo.domain.core.greeting.operations.results.GetGreetingResult;

public interface GreetingService {
    GetGreetingResult process(GetGreetingQuery query);
}
