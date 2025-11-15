package com.demo.api.rest.endpoints.example.controller;

import com.demo.presentation.handlers.example.facade.ExampleEndpointFacade;
import com.demo.presentation.handlers.example.input.requests.CreateExampleRequest;
import com.demo.presentation.handlers.example.output.responses.CreateExampleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/examples")
public class ExampleController {

    private final ExampleEndpointFacade facade;

    @PostMapping()
    public ResponseEntity<CreateExampleResponse> create(@Valid @RequestBody CreateExampleRequest req) {
        var response = facade.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}

