package com.demo.presentation.handlers.greeting.input.converters;

import com.demo.domain.core.example.operations.commands.CreateExampleCommand;
import com.demo.presentation.common.qualifier.PresentationConverter;
import com.demo.presentation.handlers.example.input.requests.CreateExampleRequest;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
@PresentationConverter
public class CreateGreetingRequestToCommandConverter
        implements Converter<CreateExampleRequest, CreateExampleCommand> {

    @Override
    public CreateExampleCommand convert(
            MappingContext<CreateExampleRequest, CreateExampleCommand> ctx) {

        var s = ctx.getSource();
        return new CreateExampleCommand(s.name());
    }
}
