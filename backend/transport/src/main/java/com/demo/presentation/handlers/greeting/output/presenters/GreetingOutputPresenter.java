package com.demo.presentation.handlers.greeting.output.presenters;

import com.demo.domain.core.greeting.messages.GreetingMessageKey;
import com.demo.domain.core.greeting.operations.results.GetGreetingResult;
import com.demo.presentation.common.contracts.OutputPresenter;
import com.demo.presentation.handlers.greeting.output.responses.GreetingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class GreetingOutputPresenter implements OutputPresenter<GetGreetingResult, GreetingResponse> {

    private final MessageSource messageSource;
    private final GreetingMessageCodeResolver codeResolver = new GreetingMessageCodeResolver();

    @Override
    public GreetingResponse toResponse(GetGreetingResult result) {
        var g = result.greeting();
        var code = codeResolver.code(result.messageKey());

        var locale = Locale.forLanguageTag(g.locale().value());

        var text = messageSource.getMessage(code, new Object[]{g.base(), g.name()}, locale);

        return new GreetingResponse(
                text,
                g.base(),
                g.name(),
                g.level().name(),
                g.context().value(),
                g.locale().value()
        );
    }

    static final class GreetingMessageCodeResolver {
        String code(GreetingMessageKey key) {
            return switch (key) {
                case MESSAGE_GREETING_TEMPLATE_BASE_WITH_NAME ->
                        "greeting.message.base.withName";
                case MESSAGE_GREETING_TEMPLATE_BASE_ONLY ->
                        "greeting.message.base.only";
                case MESSAGE_GREETING_TEMPLATE_NAME_THEN_BASE_FRIENDLY ->
                        "greeting.message.nameThenBase.friendly";
            };
        }
    }
}
