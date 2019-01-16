package com.hillel.elementary.java_geeks.utils;

import com.hillel.elementary.java_geeks.domain.Pizza;

public class Converter {

    public static int[] convertUserStringToPizzaIds(String string) {
        int[] intIds = null;
        try {
            String[] strIds = string.split(",");
            intIds = new int[strIds.length];
            for (int i = 0; i < strIds.length; i++) {
                intIds[i] = Integer.parseInt(strIds[i]);
            }
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            intIds = null;
        }
        return intIds;
    }
}

