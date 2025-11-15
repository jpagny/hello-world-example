package com.demo.domain.usecases;

import com.demo.domain.core.greeting.engines.GreetingTemplateEngine;
import com.demo.domain.core.greeting.enums.LanguageLevel;
import com.demo.domain.core.greeting.exceptions.GreetingDomainException;
import com.demo.domain.core.greeting.models.GreetingContextKey;
import com.demo.domain.core.greeting.models.LocaleTag;
import com.demo.domain.core.greeting.operations.queries.GetGreetingQuery;
import com.demo.domain.core.greeting.ports.outbound.GreetingLexiconPort;
import com.demo.domain.core.greeting.usecases.GetGreetingUseCaseImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GetGreetingUseCaseImpl")
class GetGreetingUseCaseImplTest {

    @Nested
    @DisplayName("[DEV]")
    class Dev {

        @Test
        @DisplayName("Should throw exception when query is null given handle invoked")
        void shouldThrowExceptionWhenQueryIsNullGivenHandleInvoked() {
            var port = mock(GreetingLexiconPort.class);
            var templateEngine = mock(GreetingTemplateEngine.class);
            var useCase = new GetGreetingUseCaseImpl(port, templateEngine);
            GetGreetingQuery query = null;

            assertThatThrownBy(() -> useCase.handle(query))
                    .isInstanceOf(GreetingDomainException.class);

            verifyNoInteractions(port);
        }

        @Test
        @DisplayName("Should call template engine once with level and hasName when handle invoked given valid query")
        void shouldCallTemplateEngineOnceWithLevelAndHasNameWhenHandleInvokedGivenValidQuery() {
            var port = mock(GreetingLexiconPort.class);
            var templateEngine = mock(GreetingTemplateEngine.class);
            var useCase = new GetGreetingUseCaseImpl(port, templateEngine);

            var query = mock(GetGreetingQuery.class);
            var locale = new LocaleTag("fr-FR");
            var level = LanguageLevel.NEUTRAL;
            var ctx = new GreetingContextKey("EVENING");

            when(query.locale()).thenReturn(locale);
            when(query.level()).thenReturn(level);
            when(query.context()).thenReturn(ctx);
            when(query.hasName()).thenReturn(false);

            var greeting = mock(com.demo.domain.core.greeting.models.Greeting.class);
            when(port.load(locale, level, ctx)).thenReturn(java.util.Optional.of(greeting));

            var result = useCase.handle(query);

            verify(templateEngine, times(1)).choose(level, false);
            verifyNoMoreInteractions(templateEngine);
            verify(port, times(1)).load(locale, level, ctx);
            verifyNoMoreInteractions(port);
            org.assertj.core.api.Assertions.assertThat(result).isNotNull();
        }

        @Test
        @DisplayName("Should return result with greeting from port when handle invoked given valid query")
        void shouldReturnResultWithGreetingFromPortWhenHandleInvokedGivenValidQuery() {
            var port = mock(GreetingLexiconPort.class);
            var templateEngine = mock(GreetingTemplateEngine.class);
            var useCase = new GetGreetingUseCaseImpl(port, templateEngine);

            var query = mock(GetGreetingQuery.class);
            var locale = new LocaleTag("fr-CA");
            var level = LanguageLevel.FORMAL;
            var context = new GreetingContextKey("MORNING");

            when(query.locale()).thenReturn(locale);
            when(query.level()).thenReturn(level);
            when(query.context()).thenReturn(context);
            when(query.hasName()).thenReturn(false);

            var greeting = mock(com.demo.domain.core.greeting.models.Greeting.class);
            when(port.load(locale, level, context)).thenReturn(java.util.Optional.of(greeting));
            when(templateEngine.choose(level, false))
                    .thenReturn(com.demo.domain.core.greeting.messages.GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_BASE_ONLY);

            var result = useCase.handle(query);

            org.assertj.core.api.Assertions.assertThat(result.greeting()).isSameAs(greeting);
            org.assertj.core.api.Assertions.assertThat(result.messageKey())
                    .isEqualTo(com.demo.domain.core.greeting.messages.GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_BASE_ONLY);
        }

        @Test
        @DisplayName("Should throw missing lexicon entry when port returns empty given valid query")
        void shouldThrowMissingLexiconEntryWhenPortReturnsEmptyGivenValidQuery() {
            var port = mock(GreetingLexiconPort.class);
            var templateEngine = mock(GreetingTemplateEngine.class);
            var useCase = new GetGreetingUseCaseImpl(port, templateEngine);

            var query = mock(GetGreetingQuery.class);
            var locale = new LocaleTag("xx");
            var level = LanguageLevel.NEUTRAL;
            var context = new GreetingContextKey("UNKNOWN");

            when(query.locale()).thenReturn(locale);
            when(query.level()).thenReturn(level);
            when(query.context()).thenReturn(context);
            when(port.load(locale, level, context)).thenReturn(java.util.Optional.empty());

            assertThatThrownBy(() -> useCase.handle(query))
                    .isInstanceOf(GreetingDomainException.class);

            verify(port, times(1)).load(locale, level, context);
            verifyNoMoreInteractions(port);
            verifyNoInteractions(templateEngine);
        }

        @Test
        @DisplayName("Should return key base only when name blank given neutral level")
        void shouldReturnKeyBaseOnlyWhenNameBlankGivenNeutralLevel() {
            var port = mock(GreetingLexiconPort.class);
            var templateEngine = mock(GreetingTemplateEngine.class);
            var useCase = new GetGreetingUseCaseImpl(port, templateEngine);

            var query = mock(GetGreetingQuery.class);
            var locale = new LocaleTag("fr-FR");
            var level = LanguageLevel.NEUTRAL;
            var context = new GreetingContextKey("EVENING");

            when(query.locale()).thenReturn(locale);
            when(query.level()).thenReturn(level);
            when(query.context()).thenReturn(context);
            when(query.hasName()).thenReturn(false);

            var greeting = mock(com.demo.domain.core.greeting.models.Greeting.class);
            when(port.load(locale, level, context)).thenReturn(java.util.Optional.of(greeting));
            when(templateEngine.choose(level, false))
                    .thenReturn(com.demo.domain.core.greeting.messages.GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_BASE_ONLY);

            var result = useCase.handle(query);

            org.assertj.core.api.Assertions.assertThat(result.messageKey())
                    .isEqualTo(com.demo.domain.core.greeting.messages.GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_BASE_ONLY);
        }

        @Test
        @DisplayName("Should return key base with name when name present given neutral level")
        void shouldReturnKeyBaseWithNameWhenNamePresentGivenNeutralLevel() {
            var port = mock(GreetingLexiconPort.class);
            var templateEngine = mock(GreetingTemplateEngine.class);
            var useCase = new GetGreetingUseCaseImpl(port, templateEngine);

            var query = mock(GetGreetingQuery.class);
            var locale = new LocaleTag("fr-FR");
            var level = LanguageLevel.NEUTRAL;
            var context = new GreetingContextKey("MORNING");

            when(query.locale()).thenReturn(locale);
            when(query.level()).thenReturn(level);
            when(query.context()).thenReturn(context);
            when(query.hasName()).thenReturn(true);

            var greeting = mock(com.demo.domain.core.greeting.models.Greeting.class);
            when(port.load(locale, level, context)).thenReturn(java.util.Optional.of(greeting));
            when(templateEngine.choose(level, true))
                    .thenReturn(com.demo.domain.core.greeting.messages.GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_BASE_WITH_NAME);

            var result = useCase.handle(query);

            org.assertj.core.api.Assertions.assertThat(result.messageKey())
                    .isEqualTo(com.demo.domain.core.greeting.messages.GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_BASE_WITH_NAME);
        }

        @Test
        @DisplayName("Should return key name then base friendly when name present given informal level")
        void shouldReturnKeyNameThenBaseFriendlyWhenNamePresentGivenInformalLevel() {
            var port = mock(GreetingLexiconPort.class);
            var templateEngine = mock(GreetingTemplateEngine.class);
            var useCase = new GetGreetingUseCaseImpl(port, templateEngine);

            var query = mock(GetGreetingQuery.class);
            var locale = new LocaleTag("en-US");
            var level = LanguageLevel.INFORMAL;
            var context = new GreetingContextKey("EVENING");

            when(query.locale()).thenReturn(locale);
            when(query.level()).thenReturn(level);
            when(query.context()).thenReturn(context);
            when(query.hasName()).thenReturn(true);

            var greeting = mock(com.demo.domain.core.greeting.models.Greeting.class);
            when(port.load(locale, level, context)).thenReturn(java.util.Optional.of(greeting));
            when(templateEngine.choose(level, true))
                    .thenReturn(com.demo.domain.core.greeting.messages.GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_NAME_THEN_BASE_FRIENDLY);

            var result = useCase.handle(query);

            org.assertj.core.api.Assertions.assertThat(result.messageKey())
                    .isEqualTo(com.demo.domain.core.greeting.messages.GreetingMessageKey.MESSAGE_GREETING_TEMPLATE_NAME_THEN_BASE_FRIENDLY);
        }
    }

    @Nested
    @DisplayName("[BUGFIX]")
    class Bugfix {
    }
}
