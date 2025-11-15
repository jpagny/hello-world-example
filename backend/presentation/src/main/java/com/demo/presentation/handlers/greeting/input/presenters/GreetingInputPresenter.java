package com.demo.presentation.handlers.greeting.input.presenters;

import com.demo.domain.core.greeting.enums.LanguageLevel;
import com.demo.domain.core.greeting.models.GreetingContextKey;
import com.demo.domain.core.greeting.models.LocaleTag;
import com.demo.domain.core.greeting.operations.queries.GetGreetingQuery;
import com.demo.presentation.common.contracts.InputPresenter;
import com.demo.presentation.handlers.greeting.input.requests.GreetingRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

@Slf4j
@Component
@RequiredArgsConstructor
public class GreetingInputPresenter implements InputPresenter<GreetingRequest, GetGreetingQuery> {

    // Defaults “présentation”
    private static final String DEFAULT_LOCALE = "en-US";
    private static final LanguageLevel DEFAULT_LEVEL = LanguageLevel.NEUTRAL;
    private static final ZoneId DEFAULT_ZONE = ZoneId.of("Europe/Paris");

    @Override
    public GetGreetingQuery toCommand(GreetingRequest req) {
        // 1) Normalisation des champs
        var reqLocale = (req != null && req.locale() != null && !req.locale().isBlank()) ? req.locale().trim() : DEFAULT_LOCALE;
        var reqLevel  = (req != null && req.level()  != null && !req.level().isBlank())
                ? LanguageLevel.valueOf(req.level().trim().toUpperCase())
                : DEFAULT_LEVEL;
        var name      = (req != null && req.name()   != null) ? req.name().trim() : "";
        var zone      = (req != null && req.timeZone()!= null && !req.timeZone().isBlank())
                ? ZoneId.of(req.timeZone().trim()) : DEFAULT_ZONE;
        var at        = (req != null && req.at()     != null) ? req.at() : Instant.now();

        // 2) Contexte (si absent) dérivé de l’heure locale
        var contextCode = (req != null && req.context() != null && !req.context().isBlank())
                ? req.context().trim().toUpperCase()
                : deriveContextFromTime(at, zone);

        var query = new GetGreetingQuery(
                new LocaleTag(reqLocale),
                reqLevel,
                new GreetingContextKey(contextCode),
                name
        );

        log.debug("Result value {}", query);

        // 3) Build Query domaine (complet)
        return query;
    }

    private String deriveContextFromTime(Instant at, ZoneId zone) {
        var t = at.atZone(zone).toLocalTime();
        if (t.isBefore(LocalTime.NOON)) return "MORNING";
        if (t.isBefore(LocalTime.of(18, 0))) return "MIDDAY";
        return "EVENING";
    }
}
