package com.hillel.elementary.javageeks.quadrangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShowLogicTest {
    @Test
    void shouldPrintQantityShape(){
        Shape[] arr = CreatArrey();

        assertEquals("Quadrilateral = 2;Rectangle = 2;Rhombus = 3;Square = 3",
                ShowLogic.printQantityShape(arr));
    }
    @Test
    void shouldPrintedShapeMaxArea(){
        Shape[] arr = CreatArrey();
        assertEquals(9.0,ShowLogic.returnMaxAreaShape(arr,Square.class));
    }
    @Test
    void shouldPrintedShapeMinArea(){
        Shape[] arr = CreatArrey();
        assertEquals(1.0,ShowLogic.returnMinAreaShape(arr,Square.class));
    }
    @Test
    void shouldPrintedShapeMinPerimetr(){
        Shape[] arr = CreatArrey();
        assertEquals(6,ShowLogic.returnMinPerimeterShape(arr,Rectangle.class));
    }
    @Test
    void shouldPrintedShapeMaxPerimetr(){
        Shape[] arr = CreatArrey();
        assertEquals(12,ShowLogic.returnMaxPerimeterShape(arr,Rectangle.class));
    }


    private Shape[] CreatArrey(){
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

        return arr;


    }
}