package com.hillel.elementary.javageeks.quadrangle;

public class Rectangle extends Quadrilateral {
    private int firstSide;
    private int secondSide;
    private int thirdSide;
    private int forSide;

    public Rectangle(int firstSide, int secondSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }
    @Override
    public int getPerimeter(){
        int perimeter = (firstSide + secondSide)*2;
        return perimeter;
    }
    @Override
    public double getArea(){
        double area = firstSide*secondSide;
        return area;
    }
}
