package com.demo.api.rest.endpoints.greeting.controller;

import com.demo.presentation.handlers.greeting.handle.GreetingEndpointHandler;
import com.demo.presentation.handlers.greeting.input.requests.GreetingRequest;
import com.demo.presentation.handlers.greeting.output.responses.GreetingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/greeting")
public class GreetingController {

    private final GreetingEndpointHandler handler;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GreetingResponse> present(@Valid @RequestBody GreetingRequest req) {
        var response = handler.present(req);
        return ResponseEntity.ok(response);
    }
}
