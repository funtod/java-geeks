package com.hillel.elementary.javageeks.examples.reflection.annotations.conditions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredCondition {
    Condition value();
}
