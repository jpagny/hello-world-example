package com.demo.presentation.handlers.example.input.presenters;

import com.demo.presentation.common.contracts.InputPresenter;
import com.demo.presentation.handlers.example.input.requests.CreateExampleRequest;
import com.demo.domain.core.example.operations.commands.CreateExampleCommand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CreateExampleInputPresenter
        implements InputPresenter<CreateExampleRequest, CreateExampleCommand> {

    private final ModelMapper mapper;

    public CreateExampleInputPresenter(
            @Qualifier("presentationMapper") ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CreateExampleCommand toCommand(CreateExampleRequest src) {
        return mapper.map(src, CreateExampleCommand.class);
    }
}
