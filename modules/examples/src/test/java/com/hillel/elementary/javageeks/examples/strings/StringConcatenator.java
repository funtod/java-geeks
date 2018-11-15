package com.hillel.elementary.javageeks.examples.strings;

public class StringConcatenator {


    public static String concatenate(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : strings) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }
}
