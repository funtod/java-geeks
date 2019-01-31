package com.hillel.elementary.javageeks.examples.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorExample {
    private int k;

    public ConstructorExample() {

    }

    public ConstructorExample(int k) {
        this.k = k;
    }

    void printHello() {
        System.out.println("Hello " + k);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.hillel.elementary.javageeks.examples.reflection.ConstructorExample");

        ConstructorExample constructorExample = (ConstructorExample) aClass.newInstance();
        constructorExample.printHello();


        Constructor<?> constructor = aClass.getConstructor(int.class);
        ConstructorExample contructorExampleWithNumber = (ConstructorExample) constructor.newInstance(33);
        contructorExampleWithNumber.printHello();
    }
}
