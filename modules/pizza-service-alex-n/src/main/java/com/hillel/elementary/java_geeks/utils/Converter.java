package com.hillel.elementary.java_geeks.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public final class Converter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Converter.class);

    private Converter() {
    }

    public static Integer[] convertUserStringToPizzaIds(String string) {
        Integer[] intIds;
        try {
            String[] strIds = string.split(",");
            intIds = Arrays.stream(strIds)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        } catch (NumberFormatException e) {
            LOGGER.error("Something is wrong:", e);
            intIds = null;
        }
        return intIds;
    }
}

