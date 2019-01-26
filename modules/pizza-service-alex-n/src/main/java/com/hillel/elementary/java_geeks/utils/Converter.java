package com.hillel.elementary.java_geeks.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Converter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Converter.class);

    private Converter() {
    }

    public static int[] convertUserStringToPizzaIds(String string) {
        int[] intIds;
        try {
            String[] strIds = string.split(",");
            intIds = new int[strIds.length];
            for (int i = 0; i < strIds.length; i++) {
                intIds[i] = Integer.parseInt(strIds[i]);
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Something is wrong:", e);
            intIds = null;
        }
        return intIds;
    }
}

