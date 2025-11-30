package com.demo.presentation.common.i18n.impl;

import com.demo.domain.commons.exceptions.engine.ErrorContext;
import com.demo.domain.commons.exceptions.engine.IBusinessError;
import com.demo.presentation.common.i18n.BusinessErrorMessageResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Locale;

@Component
@RequiredArgsConstructor
@Slf4j
public class BusinessErrorMessageResolverImpl implements BusinessErrorMessageResolver {

    private static final String ERROR_KEY_PREFIX = "error";
    private static final String KEY_SEPARATOR   = ".";
    private static final String DEFAULT_CONTEXT = "global";
    private static final String FALLBACK_INTERNAL_ERROR_CODE = "internal_error";

    private final MessageSourceAccessor accessor;

    @SuppressWarnings("DataFlowIssue")
    @Override
    public String resolve(IBusinessError error, Locale locale, Object... args) {
        if (error == null || error.code() == null) {
            return FALLBACK_INTERNAL_ERROR_CODE;
        }

        final String errorNameLower;
        if (error instanceof Enum<?> e) {
            errorNameLower = e.name().toLowerCase(Locale.ROOT);
        } else {
            errorNameLower = error.code().name().toLowerCase(Locale.ROOT);
        }

        final var context = resolveContext(error);

        final var ctxKey = String.join(KEY_SEPARATOR, ERROR_KEY_PREFIX, context, errorNameLower);
        final var ctxMsg = accessor.getMessage(ctxKey, args, null, locale);
        if (StringUtils.hasText(ctxMsg)) return ctxMsg;

        /*
        final var globalKey = String.join(KEY_SEPARATOR, ERROR_KEY_PREFIX, errorNameLower);
        final var globalMsg = accessor.getMessage(globalKey, args, null, locale);
        if (globalMsg != null) return globalMsg;

        if (error instanceof Enum<?> e2) {
            return e2.name();
        }

        return error.code().name();
         */

        var ctxKeyUnknown = String.join(KEY_SEPARATOR,context, "unknown");

        log.warn(
                "No i18n message found for keys {} (locale={}, context={}, code={}). Falling back to '{}'",
                ctxKey,
                locale,
                context,
                errorNameLower,
                ctxKeyUnknown
        );

        return accessor.getMessage(ctxKeyUnknown, args, null, locale);
    }

    private String resolveContext(IBusinessError error) {
        var ann = error.getClass().getAnnotation(ErrorContext.class);
        return (ann != null && ann.value() != null && !ann.value().isBlank())
                ? ann.value().toLowerCase(Locale.ROOT)
                : DEFAULT_CONTEXT;
    }
}
