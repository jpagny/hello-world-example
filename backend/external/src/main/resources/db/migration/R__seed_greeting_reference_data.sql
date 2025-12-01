-- language levels
MERGE INTO language_level (code, label) KEY(code) VALUES
    ('FORMAL',  'Formal'),
    ('NEUTRAL', 'Neutral'),
    ('INFORMAL','Informal');

-- contexts
MERGE INTO greeting_context (code, description) KEY(code) VALUES
    ('MORNING', 'Morning greeting'),
    ('MIDDAY',  'Midday greeting'),
    ('EVENING', 'Evening greeting');

-- locales
MERGE INTO locale_tag (tag, language, script, region) KEY(tag) VALUES
    ('fr-FR', 'fr', NULL, 'FR'),
    ('fr-CA', 'fr', NULL, 'CA'),
    ('en-US', 'en', NULL, 'US');

-- lexicon (ne pas passer id non plus)
-- en-US / NEUTRAL / MORNING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Good morning'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='en-US' AND lv.code='NEUTRAL' AND cx.code='MORNING';

-- en-US / NEUTRAL / MIDDAY
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Good afternoon'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='en-US' AND lv.code='NEUTRAL' AND cx.code='MIDDAY';

-- en-US / NEUTRAL / EVENING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Good evening'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='en-US' AND lv.code='NEUTRAL' AND cx.code='EVENING';

-- fr-FR / NEUTRAL / MIDDAY
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bon après-midi'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-FR' AND lv.code='NEUTRAL' AND cx.code='MIDDAY';

-- fr-FR / NEUTRAL / EVENING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bonsoir'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-FR' AND lv.code='NEUTRAL' AND cx.code='EVENING';

-- fr-CA / NEUTRAL / MIDDAY
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bon après-midi'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-CA' AND lv.code='NEUTRAL' AND cx.code='MIDDAY';

-- fr-CA / NEUTRAL / EVENING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bonsoir'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-CA' AND lv.code='NEUTRAL' AND cx.code='EVENING';

-- en-US / FORMAL / MORNING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Good morning'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='en-US' AND lv.code='FORMAL' AND cx.code='MORNING';

-- en-US / FORMAL / MIDDAY
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Good afternoon'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='en-US' AND lv.code='FORMAL' AND cx.code='MIDDAY';

-- en-US / FORMAL / EVENING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Good evening'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='en-US' AND lv.code='FORMAL' AND cx.code='EVENING';

-- en-US / INFORMAL / MORNING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Hi'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='en-US' AND lv.code='INFORMAL' AND cx.code='MORNING';

-- en-US / INFORMAL / MIDDAY
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Hey'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='en-US' AND lv.code='INFORMAL' AND cx.code='MIDDAY';

-- en-US / INFORMAL / EVENING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Hi there'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='en-US' AND lv.code='INFORMAL' AND cx.code='EVENING';

-- fr-FR / FORMAL / MORNING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bonjour'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-FR' AND lv.code='FORMAL' AND cx.code='MORNING';

-- fr-FR / FORMAL / MIDDAY
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bonjour'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-FR' AND lv.code='FORMAL' AND cx.code='MIDDAY';

-- fr-FR / FORMAL / EVENING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bonsoir'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-FR' AND lv.code='FORMAL' AND cx.code='EVENING';

-- fr-FR / INFORMAL / MORNING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Salut'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-FR' AND lv.code='INFORMAL' AND cx.code='MORNING';

-- fr-FR / INFORMAL / MIDDAY
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Salut'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-FR' AND lv.code='INFORMAL' AND cx.code='MIDDAY';

-- fr-FR / INFORMAL / EVENING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Salut'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-FR' AND lv.code='INFORMAL' AND cx.code='EVENING';

-- fr-CA / FORMAL / MORNING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bonjour'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-CA' AND lv.code='FORMAL' AND cx.code='MORNING';

-- fr-CA / FORMAL / MIDDAY
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bonjour'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-CA' AND lv.code='FORMAL' AND cx.code='MIDDAY';

-- fr-CA / FORMAL / EVENING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bonsoir'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-CA' AND lv.code='FORMAL' AND cx.code='EVENING';

-- fr-CA / INFORMAL / MORNING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Salut'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-CA' AND lv.code='INFORMAL' AND cx.code='MORNING';

-- fr-CA / INFORMAL / MIDDAY
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Salut'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-CA' AND lv.code='INFORMAL' AND cx.code='MIDDAY';

-- fr-CA / INFORMAL / EVENING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Salut'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-CA' AND lv.code='INFORMAL' AND cx.code='EVENING';

-- fr-FR / NEUTRAL / MORNING
MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bonjour'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-FR' AND lv.code='NEUTRAL' AND cx.code='MORNING';

MERGE INTO greeting_lexicon (locale_id, level_id, context_id, base_text)
    KEY(locale_id, level_id, context_id)
SELECT l.id, lv.id, cx.id, 'Bon matin'
FROM locale_tag l, language_level lv, greeting_context cx
WHERE l.tag='fr-CA' AND lv.code='NEUTRAL' AND cx.code='MORNING';

