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
