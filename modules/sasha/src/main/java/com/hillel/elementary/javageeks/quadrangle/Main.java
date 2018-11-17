package com.hillel.elementary.javageeks.quadrangle;


public class Main {
    public static void main(String[] args) {
        Shape[] arr = new Quadrilateral[10];
        arr[0] = new Quadrilateral(2, 4, 3, 5);
        arr[1] = new Square(3);
        arr[2] = new Rectangle(2, 4);
        arr[3] = new Rhombus(3, 5);
        arr[4] = new Square(2);
        arr[5] = new Quadrilateral(1, 2, 3, 4);
        arr[6] = new Square(1);
        arr[7] = new Rectangle(1, 2);
        arr[8] = new Rhombus(2, 3);
        arr[9] = new Rhombus(1, 2);

        int quantityQuadrilateral = 0;
        int quantitySquare = 0;
        int quantityRhombus = 0;
        int quantityRectangle = 0;

        double areaSquareMax = 0;
        double areaSquareMin = 0;
        double areaRhombusMax = 0;
        double areaRhombusMin = 0;
        double areaRectangleMax = 0;
        double areaRectangleMin = 0;
        double areaQuadrilateralMax = 0;
        double areaQuadrilateralMin = 0;

        int perimeterSquareMax = 0;
        int perimeterSquareMin = 0;
        int perimeterQuadrilateralMax = 0;
        int perimeterQuadrilateralMin = 0;
        int perimeterRectangleMax = 0;
        int perimeterRectangleMin = 0;
        int perimeterRhombusMax = 0;
        int perimeterRhombusMin = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof Square) {
                quantitySquare++;
                if (areaSquareMax == 0) {
                    areaSquareMax = arr[i].getArea();
                    areaSquareMin = arr[i].getArea();
                }
                else {
                    if (areaSquareMax < arr[i].getArea()) {
                        areaSquareMax = arr[i].getArea();
                    }
                    if (areaSquareMin > arr[i].getArea()) {
                        areaSquareMin = arr[i].getArea();
                    }
                }
                if(perimeterSquareMax == 0){
                    perimeterSquareMax = arr[i].getPerimeter();
                    perimeterSquareMin = arr[i].getPerimeter();
                }
                else {
                    if(perimeterSquareMax < arr[i].getPerimeter()){
                        perimeterSquareMax = arr[i].getPerimeter();
                    }
                    if(perimeterSquareMin > arr[i].getPerimeter()){
                        perimeterSquareMin = arr[i].getPerimeter();
                    }
                }

            }


            if(arr[i] instanceof Quadrilateral && !(arr[i] instanceof Rhombus)
                    && !(arr[i] instanceof Rectangle)
                    && !(arr[i] instanceof Square) ) {
                quantityQuadrilateral++;
                if (areaQuadrilateralMax == 0) {
                    areaQuadrilateralMax = arr[i].getArea();
                    areaQuadrilateralMin = arr[i].getArea();
                } else {
                    if (areaQuadrilateralMax < arr[i].getArea()) {
                        areaQuadrilateralMax = arr[i].getArea();
                    }
                    if (areaQuadrilateralMin > arr[i].getArea()) {
                        areaQuadrilateralMin = arr[i].getArea();
                    }
                }
                if(perimeterQuadrilateralMax == 0){
                    perimeterQuadrilateralMax = arr[i].getPerimeter();
                    perimeterQuadrilateralMin = arr[i].getPerimeter();
                }
                else {
                    if(perimeterQuadrilateralMax < arr[i].getPerimeter()){
                        perimeterQuadrilateralMax = arr[i].getPerimeter();
                    }
                    if(perimeterQuadrilateralMin > arr[i].getPerimeter()){
                        perimeterQuadrilateralMin = arr[i].getPerimeter();
                    }
                }
            }
            if (arr[i] instanceof Rhombus) {
                quantityRhombus++;
                if (areaRhombusMax == 0) {
                    areaRhombusMax = arr[i].getArea();
                    areaRhombusMin = arr[i].getArea();
                }
                else {
                    if (areaRhombusMax < arr[i].getArea()) {
                        areaRhombusMax = arr[i].getArea();
                    }
                    if (areaRhombusMin > arr[i].getArea()) {
                        areaRhombusMin = arr[i].getArea();
                    }
                }
                    if (perimeterRhombusMax == 0) {
                        perimeterRhombusMax = arr[i].getPerimeter();
                        perimeterRhombusMin = arr[i].getPerimeter();
                    }

                    else {
                        if(perimeterRhombusMax < arr[i].getPerimeter()){
                            perimeterRhombusMax = arr[i].getPerimeter();
                        }
                        if(perimeterRhombusMin > arr[i].getPerimeter()){
                            perimeterRhombusMin = arr[i].getPerimeter();
                        }
                    }

                }
                if (arr[i] instanceof Rectangle) {
                    quantityRectangle++;
                    if (areaRectangleMax == 0) {
                        areaRectangleMax = arr[i].getArea();
                        areaRectangleMin = arr[i].getArea();
                    } else {
                        if (areaRectangleMax < arr[i].getArea()) {
                            areaRectangleMax = arr[i].getArea();
                        }
                        if (areaRectangleMin > arr[i].getArea()) {
                            areaRectangleMin = arr[i].getArea();
                        }
                    }
                    if(perimeterRectangleMax == 0){
                        perimeterRectangleMax = arr[i].getPerimeter();
                        perimeterRectangleMin = arr[i].getPerimeter();
                    }
                    else {
                        if(perimeterRectangleMax < arr[i].getPerimeter()){
                            perimeterRectangleMax = arr[i].getPerimeter();
                        }
                        if(perimeterRectangleMin > arr[i].getPerimeter()){
                            perimeterRectangleMin = arr[i].getPerimeter();
                        }
                    }

                }
            }

        System.out.println("Quadrilateral = "+ quantityQuadrilateral);
        System.out.println("Rectangle = "+ quantityRectangle );
        System.out.println("Rhombus = "+ quantityRhombus);
        System.out.println("Square = "+ quantitySquare );

        System.out.println("areaQuadrilateralMax = " + areaQuadrilateralMax);
        System.out.println( "areaQuadrilateralMin = " + areaQuadrilateralMin);
        System.out.println( "areaRectangleMax = " + areaRectangleMax);
        System.out.println("areaRectangleMin = " + areaRectangleMin);
        System.out.println("areaRhombusMax = " + areaRhombusMax);
        System.out.println("areaRhombusMin = " + areaRhombusMin);
        System.out.println("areaSquareMax = " + areaSquareMax);
        System.out.println("areaSquareMin" + areaSquareMin);

        System.out.println("perimeterQuadrilateralMax = " + perimeterQuadrilateralMax);
        System.out.println("perimeterQuadrilateralMin = " + perimeterQuadrilateralMin);
        System.out.println("perimeterRectangleMax = " + perimeterRectangleMax);
        System.out.println("perimeterRectangleMin = " + perimeterRectangleMin);
        System.out.println("perimeterRhombusMax = " + perimeterRhombusMax);
        System.out.println("perimeterRhombusMin = " + perimeterRhombusMin);
        System.out.println("perimeterSquareMax = " + perimeterSquareMax);
        System.out.println("perimeterSquareMin = " + perimeterSquareMin);

    }
}
