package com.hillel.elementary.javageeks.examples.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccessModificationExample {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<ClassWithPrivateMethod> aClass = ClassWithPrivateMethod.class;
        Method printHelloMethod = aClass.getDeclaredMethod("printHello");
        try {
            printHelloMethod.invoke(aClass.newInstance(), null);
        } catch (IllegalAccessException e) {
            System.out.println("No access to printHello() method " + e);
        }

        System.out.println("printHelloMethod.isAccessible(): " + printHelloMethod.isAccessible());
        printHelloMethod.setAccessible(true);
        System.out.println("printHelloMethod.isAccessible(): " +  printHelloMethod.isAccessible());

        printHelloMethod.invoke(aClass.newInstance(), null);
    }
}


class ClassWithPrivateMethod{

    private void printHello() {
        System.out.println("Hello");
    }
}
