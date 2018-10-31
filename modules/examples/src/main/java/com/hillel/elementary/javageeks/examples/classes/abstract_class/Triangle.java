package com.hillel.elementary.javageeks.examples.classes.abstract_class;

public class Triangle extends Shape{
    private int firstSide;
    private int secondSide;
    private int thirdSide;

    public Triangle(int firstSide, int secondSide, int thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double getArea() {
        double halfPerimeter = (firstSide + secondSide + thirdSide) / 2.0;
        return Math.sqrt(halfPerimeter
                * (halfPerimeter - firstSide)
                * (halfPerimeter - secondSide)
                * (halfPerimeter - thirdSide));
    }
}
