package com.demo.external.greeting.persistence.jparepository;

import com.demo.external.greeting.persistence.entities.GreetingLexiconEntity;
import com.demo.external.greeting.persistence.projections.GreetingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GreetingLexiconJpaRepository extends JpaRepository<GreetingLexiconEntity, Long> {

    @Query(value = """
        SELECT 
            gl.base_text   AS baseText,
            loc.tag        AS localeTag,
            lvl.code       AS levelCode,
            ctx.code       AS contextCode
        FROM greeting_lexicon gl
        JOIN locale_tag      loc ON loc.id  = gl.locale_id
        JOIN language_level  lvl ON lvl.id  = gl.level_id
        JOIN greeting_context ctx ON ctx.id = gl.context_id
        WHERE loc.tag  = :localeTag
          AND lvl.code = :levelCode
          AND ctx.code = :contextCode
        """,
            nativeQuery = true)
    Optional<GreetingProjection> findProjectionByKeys(
            @Param("localeTag") String localeTag,
            @Param("levelCode") String levelCode,
            @Param("contextCode") String contextCode
    );
}
