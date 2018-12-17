package com.hillel.elementary.javageeks.quadrangle;

public class ShowLogic {
    public static String printQantityShape(Shape[] arr) {
        String str;

        int quantityQuadrilateral = 0;
        int quantitySquare = 0;
        int quantityRhombus = 0;
        int quantityRectangle = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof Quadrilateral) {
                if (arr[i] instanceof Square) {
                    quantitySquare++;
                }
                if (arr[i] instanceof Rectangle) {
                    quantityRectangle++;
                }
                if (arr[i] instanceof Rhombus) {
                    quantityRhombus++;
                }
                if (arr[i] instanceof Quadrilateral && !(arr[i] instanceof Rhombus)
                        && !(arr[i] instanceof Rectangle)
                        && !(arr[i] instanceof Square)) {
                    quantityQuadrilateral++;
                }
            }


        }
        return str = "Quadrilateral = " + quantityQuadrilateral + ";" +
                "Rectangle = " + quantityRectangle + ";" +
                "Rhombus = " + quantityRhombus + ";" +
                "Square = " + quantitySquare;

    }

    public static double returnMaxAreaShape(Shape[] arr, Class className) {
        double areaShapeMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getClass() == className) {

                if (areaShapeMax < arr[i].getArea()) {
                    areaShapeMax = arr[i].getArea();
                }

            }

        }

        return areaShapeMax;
    }

    public static double returnMinAreaShape(Shape[] arr, Class className) {
        double areaShapeMin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getClass() == className) {
                if (areaShapeMin == 0) {
                    areaShapeMin = arr[i].getArea();
                }
                if (areaShapeMin > arr[i].getArea()) {
                    areaShapeMin = arr[i].getArea();
                }
            }
        }
        return areaShapeMin;
    }

    public static int returnMaxPerimeterShape(Shape[] arr, Class className) {
        int perimetrMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getClass() == className) {
                if (perimetrMax < arr[i].getPerimeter()) {
                    perimetrMax = arr[i].getPerimeter();
                }
            }
        }

        return perimetrMax;

    }

    public static int returnMinPerimeterShape(Shape[] arr, Class className) {
        int perimetrMin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getClass() == className) {
                if (perimetrMin == 0) {
                    perimetrMin = arr[i].getPerimeter();
                }
                if (perimetrMin > arr[i].getPerimeter()) {
                    perimetrMin = arr[i].getPerimeter();
                }

            }
        }
        return perimetrMin;
    }

}
