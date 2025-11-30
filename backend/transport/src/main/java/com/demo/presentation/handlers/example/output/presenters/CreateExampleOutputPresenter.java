package com.demo.presentation.handlers.example.output.presenters;

import com.demo.presentation.common.contracts.OutputPresenter;
import com.demo.domain.core.example.operations.results.CreateExampleResult;
import com.demo.presentation.handlers.example.output.responses.CreateExampleResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CreateExampleOutputPresenter
        implements OutputPresenter<CreateExampleResult, CreateExampleResponse> {

    private final ModelMapper mapper;

    public CreateExampleOutputPresenter(
            @Qualifier("presentationMapper") ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CreateExampleResponse toResponse(CreateExampleResult result) {
        return mapper.map(result, CreateExampleResponse.class);
    }
}
