package com.hillel.elementary.javageeks.quadrangle;

public class Square extends Quadrilateral {
    private int firstSide;
    private int secondSide;
    private int thirdSide;
    private int forSide;

    public Square(int firstSide, int secondSide, int thirdSide, int forSide, int firstSide1, int secondSide1, int thirdSide1, int forSide1) {
        super(firstSide, secondSide, thirdSide, forSide);
        this.firstSide = firstSide1;
        this.secondSide = secondSide1;
        this.thirdSide = thirdSide1;
        this.forSide = forSide1;
    }

    public Square(int firstSide) {
        this.firstSide = firstSide;
    }

    @Override
    public int getPerimeter(){
        int perimeter = firstSide *4;
        return perimeter;
    }
    @Override
    public double getArea(){
        double area = firstSide * firstSide;
        return area;
    }
}
