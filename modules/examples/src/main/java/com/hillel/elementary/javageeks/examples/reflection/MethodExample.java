package com.hillel.elementary.javageeks.examples.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodExample {

    public static void main(String[] args) {
        String str = "This is a string here. Hello";
        try {
            Class strClass = str.getClass();
            Method indexM = strClass.getMethod("indexOf", String.class, int.class);
            Object result = indexM.invoke(str, ".", 8);
            System.out.println(result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
