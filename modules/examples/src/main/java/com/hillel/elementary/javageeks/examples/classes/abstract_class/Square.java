package com.hillel.elementary.javageeks.examples.classes.abstract_class;

public class Square extends Shape{
    private int length;

    public Square(int length) {
        this.length = length;
    }

    @Override
    double getArea() {
        return length * length * 2;
    }
}
