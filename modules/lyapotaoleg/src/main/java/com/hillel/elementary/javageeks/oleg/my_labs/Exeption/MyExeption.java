package com.hillel.elementary.javageeks.oleg.my_labs.Exeption;

public class MyExeption extends Exception {
    String field;
    public MyExeption(String field) {
        this.field = field;
    }
    @Override
    public String toString() {
        return "MyExeption: fild=" + field + " Length of the entered text is insufficient.";
    }
}
