package com.demo.domain.core.greeting.usecases;

import com.demo.domain.core.greeting.engines.DefaultGreetingTemplateEngine;
import com.demo.domain.core.greeting.exceptions.GreetingDomainException;
import com.demo.domain.core.greeting.operations.queries.GetGreetingQuery;
import com.demo.domain.core.greeting.operations.results.GetGreetingResult;
import com.demo.domain.core.greeting.ports.input.GetGreetingUseCase;
import com.demo.domain.core.greeting.ports.outbound.GreetingLexiconPort;


public class GetGreetingUseCaseImpl implements GetGreetingUseCase {

    private final GreetingLexiconPort lexicon;

    static final DefaultGreetingTemplateEngine INSTANCE = new DefaultGreetingTemplateEngine();


    public GetGreetingUseCaseImpl(GreetingLexiconPort lexicon) {
        this.lexicon = lexicon;
    }

    @Override
    public GetGreetingResult handle(GetGreetingQuery query) {

        if (query == null) {
            throw GreetingDomainException.invalidQuery();
        }

        final var greeting = lexicon.load(query.locale(), query.level(), query.context())
                .orElseThrow(() -> GreetingDomainException.missingLexiconEntry(
                        query.locale().value(),
                        query.level().name(),
                        query.context().value(),
                        query.name()
                ));

        final var messageKey = INSTANCE.choose(query.level(), query.hasName());

        return new GetGreetingResult(messageKey, greeting);
    }

}