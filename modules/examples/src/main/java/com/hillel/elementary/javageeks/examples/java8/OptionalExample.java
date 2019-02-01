package com.hillel.elementary.javageeks.examples.java8;

import java.util.Optional;
import java.util.Random;

public class OptionalExample {

    public static void main(String[] args) {

        Optional<String> value = Optional.ofNullable(get());

        int i = 1;

        value.map(val -> val + i)
                .orElseThrow(() -> new IllegalArgumentException(""));

    }


    static String get() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return "";
        } else {
            return null;
        }
    }
}
