package com.hillel.elementary.java_geeks.utils;

public final class Converter {

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
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            intIds = null;
        }
        return intIds;
    }
}

