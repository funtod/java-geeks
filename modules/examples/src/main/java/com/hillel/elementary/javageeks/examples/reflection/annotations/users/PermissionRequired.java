package com.hillel.elementary.javageeks.examples.reflection.annotations.users;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionRequired {
    User.Permission value();
}
