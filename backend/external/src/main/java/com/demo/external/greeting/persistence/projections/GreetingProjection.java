package com.demo.external.greeting.persistence.projections;

public interface GreetingProjection {
    String getBaseText();
    String getLocaleTag();
    String getLevelCode();
    String getContextCode();
}