package com.demo.presentation.handlers.example.output.converters;

import com.demo.presentation.common.qualifier.PresentationConverter;
import com.demo.presentation.handlers.example.output.responses.CreateExampleResponse;
import com.demo.domain.core.example.messages.ExampleMessageKey;
import com.demo.presentation.handlers.example.resolver.ExampleMessageResolver;
import com.demo.domain.core.example.operations.results.CreateExampleResult;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
@PresentationConverter
@RequiredArgsConstructor
public class CreateExampleResultToResponseConverter
        implements Converter<CreateExampleResult, CreateExampleResponse> {

    private final ExampleMessageResolver messageResolver;

    @Override
    public CreateExampleResponse convert(MappingContext<CreateExampleResult, CreateExampleResponse> ctx) {
        var src = ctx.getSource();

        var message = messageResolver.resolve(
                ExampleMessageKey.EXAMPLE_CREATED,
                src.name()
        );

        return new CreateExampleResponse(String.valueOf(src.id()), message);
    }
}
