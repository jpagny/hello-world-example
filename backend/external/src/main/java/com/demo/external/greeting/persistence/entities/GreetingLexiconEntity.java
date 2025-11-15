package com.demo.external.greeting.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "greeting_lexicon",
        uniqueConstraints = @UniqueConstraint(name = "uk_greeting_lexicon", columnNames = {"locale_id","level_id","context_id"})
)
public class GreetingLexiconEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
