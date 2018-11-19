package com.hillel.elementary.javageeks.examples.classes;

public class Parent {

    String name;
    Object value = null;


    public Parent(String nameOf) {
        name = nameOf;
    }

    public Parent(String nameOf, Object valueOf) {
        name = nameOf;
        value = valueOf;
    }


    public String nameOf() {
        return name;
    }

    public Object valueOf() {
        return value;
    }
}

class Child extends Parent {

    private String myColor;

    {
        this.name = "other name";
        this.value = "";
    }

    public Child(String name, Object value) {
        super(name, value); //вызов конструктора суперкласса
    }

    public Child(String name) {
        this(name, "transparent"); // вызов первого конструктора
    }

    public Child(String name, Object value, String colorName) {
        super(name, value);
        myColor = colorName;
    }

    public Object valueOf() {
        Object retval = super.valueOf(); // сначала выполнить метод valueOf() суперкласса
        if (myColor == null) return retval;
        else return retval + myColor;
    }
}
