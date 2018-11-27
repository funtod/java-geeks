package com.hillel.elementary.javageeks.quadrangle;

public class Rhombus extends Quadrilateral {
    private int firstSide;
    private int secondSide;
    private int thirdSide;
    private int forSide;
    private int diagonalOne;
    private int diagonalTwo;

    public Rhombus(int diagonalOne, int diagonalTwo) {
        this.diagonalOne = diagonalOne;
        this.diagonalTwo = diagonalTwo;
    }
    @Override
    public int getPerimeter(){
        int perimeter = (int)(Math.sqrt((diagonalOne*diagonalTwo)/2))*4;
        return perimeter;
    }
    @Override
    public double getArea(){
        double area = (diagonalOne*diagonalTwo)/2;
        return area;
    }
}
