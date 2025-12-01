package com.demo.external.greeting.adapters;

import com.demo.domain.core.greeting.enums.LanguageLevel;
import com.demo.domain.core.greeting.models.Greeting;
import com.demo.domain.core.greeting.models.GreetingContextKey;
import com.demo.domain.core.greeting.models.LocaleTag;
import com.demo.domain.core.greeting.ports.outbound.GreetingLexiconPort;
import com.demo.external.greeting.persistence.jparepository.GreetingLexiconJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GreetingLexiconAdapter implements GreetingLexiconPort {

    private final GreetingLexiconJpaRepository repo;

    public GreetingLexiconAdapter(GreetingLexiconJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Greeting> load(LocaleTag locale, LanguageLevel level, GreetingContextKey context, String name) {
        return repo.findProjectionByKeys(locale.value(), level.name(), context.value())
                .map(p -> new Greeting(
                        p.getBaseText(),
                        name,
                        LanguageLevel.valueOf(p.getLevelCode()),
                        new GreetingContextKey(p.getContextCode()),
                        new LocaleTag(p.getLocaleTag())
                ));
    }
}
