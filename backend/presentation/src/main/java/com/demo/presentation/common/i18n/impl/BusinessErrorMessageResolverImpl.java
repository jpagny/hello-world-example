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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class BusinessErrorMessageResolverImpl implements BusinessErrorMessageResolver {

    private final ConcurrentMap<Class<?>, String> contextCache = new ConcurrentHashMap<>();
    private final ConcurrentMap<IBusinessError, String> enumNameLowerCache = new ConcurrentHashMap<>();



    private static final String ERROR_KEY_PREFIX = "error";
    private static final String KEY_SEPARATOR   = ".";
    private static final String DEFAULT_CONTEXT = "global";
    private static final String FALLBACK_INTERNAL_ERROR_CODE = "internal_error";

    private final MessageSourceAccessor accessor;

    @SuppressWarnings("DataFlowIssue")
    @Override
    public String resolve(IBusinessError error, Locale locale, Object... args) {
        log.debug("Passe ici {}", error);

        if (error == null || error.code() == null) {
            return FALLBACK_INTERNAL_ERROR_CODE;
        }

        final var enumNameLower = enumNameLower(error);
        final var codeLower     = error.code().name().toLowerCase(Locale.ROOT);
        final var context       = resolveContext(error);

        // 1) enum + contexte
        final var enumCtxKey = String.join(KEY_SEPARATOR, ERROR_KEY_PREFIX, context, enumNameLower);
        final var enumCtxMsg = accessor.getMessage(enumCtxKey, args, null, locale);
        if (StringUtils.hasText(enumCtxMsg)) return enumCtxMsg;

        // 2) enum global
        final var enumGlobalKey = String.join(KEY_SEPARATOR, ERROR_KEY_PREFIX, enumNameLower);
        final var enumGlobalMsg = accessor.getMessage(enumGlobalKey, args, null, locale);
        if (StringUtils.hasText(enumGlobalMsg)) return enumGlobalMsg;

        // 3) code + contexte
        final var codeCtxKey = String.join(KEY_SEPARATOR, ERROR_KEY_PREFIX, context, codeLower);
        final var codeCtxMsg = accessor.getMessage(codeCtxKey, args, null, locale);
        if (StringUtils.hasText(codeCtxMsg)) return codeCtxMsg;

        // 4) code global
        final var codeGlobalKey = String.join(KEY_SEPARATOR, ERROR_KEY_PREFIX, codeLower);
        final var codeGlobalMsg = accessor.getMessage(codeGlobalKey, args, null, locale);
        if (StringUtils.hasText(codeGlobalMsg)) return codeGlobalMsg;

        log.debug("Aucune clé valide trouvée, fallback sur {}", error.code().name());
        return error.code().name();
    }

    private String enumNameLower(IBusinessError error) {
        return enumNameLowerCache.computeIfAbsent(error, e ->
                ((Enum<?>) e).name().toLowerCase(Locale.ROOT)
        );
    }


    private String resolveContext(IBusinessError error) {
        return contextCache.computeIfAbsent(error.getClass(), cls -> {
            var ann = cls.getAnnotation(ErrorContext.class);
            var ctx = (ann != null && StringUtils.hasText(ann.value())) ? ann.value() : DEFAULT_CONTEXT;
            return ctx.toLowerCase(Locale.ROOT);
        });
    }

}
