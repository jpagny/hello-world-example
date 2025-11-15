package com.demo.presentation.representation.example.input.converters;

import com.demo.presentation.common.qualifier.PresentationConverter;
import com.demo.presentation.handlers.example.input.requests.CreateExampleRequest;
import com.demo.domain.core.example.operations.commands.CreateExampleCommand;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
@PresentationConverter
public class CreateExampleRequestToCommandConverter
        implements Converter<CreateExampleRequest, CreateExampleCommand> {

    @Override
    public CreateExampleCommand convert(
            MappingContext<CreateExampleRequest, CreateExampleCommand> ctx) {

        var s = ctx.getSource();
        return new CreateExampleCommand(s.name());
    }
}
