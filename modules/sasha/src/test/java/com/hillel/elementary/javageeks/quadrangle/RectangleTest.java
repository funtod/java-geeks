package com.hillel.elementary.javageeks.quadrangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void shouldCalculateArea(){
       Quadrilateral rectangle = new Rectangle(10,15);
       double area = rectangle.getArea();
       assertEquals(150,rectangle.getArea());
    }
    @Test
    void shouldCalculatePerimeter(){
        Quadrilateral rectangle = new Rectangle(10,15);
        int perimeter = rectangle.getPerimeter();
        assertEquals(50,rectangle.getPerimeter());
    }

}