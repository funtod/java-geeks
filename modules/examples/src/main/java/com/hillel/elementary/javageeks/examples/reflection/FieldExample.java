package com.hillel.elementary.javageeks.examples.reflection;

import java.lang.reflect.Field;

public class FieldExample {
    private int val = 12;

    public static void printField(Object o, String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = o.getClass().getDeclaredField(name);
        System.out.println(field.get(o));
    }

    public static void setField(Object o, String name, int newValue) throws NoSuchFieldException, IllegalAccessException {
        Field field = o.getClass().getDeclaredField(name);
        field.set(o, newValue);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        FieldExample fieldExample = new FieldExample();

        printField(fieldExample, "val");
        setField(fieldExample, "val", 20);
        printField(fieldExample, "val");
    }
}