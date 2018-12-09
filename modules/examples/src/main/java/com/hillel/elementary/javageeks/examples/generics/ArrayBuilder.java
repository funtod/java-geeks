package com.hillel.elementary.javageeks.examples.generics;

import java.util.Arrays;
import java.util.List;

public class ArrayBuilder {

    @SuppressWarnings({"unchecked", "varargs"})
    public static <T> void addToList(List<T> listArg, T... elements) {
        for (T element : elements) {
            listArg.add(element);
        }
    }

    public static void faultyMethod(List<String>... lists) {
        Object[] objectArray = lists;     // Valid
        objectArray[0] = Arrays.asList(42);
        String s = lists[0].get(0);       // ClassCastException thrown here
    }
}
