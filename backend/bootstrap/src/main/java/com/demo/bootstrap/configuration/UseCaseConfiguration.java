package com.demo.bootstrap.configuration;

import com.demo.domain.core.example.ports.input.CreateExampleUseCase;
import com.demo.domain.core.example.usecases.CreateExampleUseCaseImpl;
import com.demo.domain.core.greeting.ports.input.GetGreetingUseCase;
import com.demo.domain.core.greeting.ports.outbound.GreetingLexiconPort;
import com.demo.domain.core.greeting.usecases.GetGreetingUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    CreateExampleUseCase createExampleUseCase() {
        return new CreateExampleUseCaseImpl();
    }

    @Bean
    GetGreetingUseCase getGreetingUseCase(GreetingLexiconPort lexicon) {
        return new GetGreetingUseCaseImpl(lexicon);
    }
}
