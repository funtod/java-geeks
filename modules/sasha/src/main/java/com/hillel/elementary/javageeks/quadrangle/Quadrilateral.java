package com.hillel.elementary.javageeks.quadrangle;

public class Quadrilateral extends Shape {
    private int firstSide;
    private int secondSide;
    private int thirdSide;
    private int forSide;

    public Quadrilateral(int firstSide, int secondSide, int thirdSide, int forSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        this.forSide = forSide;
    }

    public Quadrilateral() {
    }

    public int getPerimeter(){
        int perimeter = firstSide + secondSide + thirdSide + forSide;
        return perimeter;
    }
    public double getArea(){
        double halfPerimeter = (firstSide + secondSide + thirdSide + forSide) / 2.0;
        return Math.sqrt(
                  (halfPerimeter - firstSide)
                * (halfPerimeter - secondSide)
                * (halfPerimeter - thirdSide)
                * (halfPerimeter - forSide));
    }

}
