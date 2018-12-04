package com.hillel.elementary.javageeks.quadrangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    void shouldCalculateArea(){
        Quadrilateral square = new Square(2);
        double area = square.getArea();
        assertEquals(4,square.getArea());
    }
    @Test
    void shouldCalculatePerimeter(){
        Quadrilateral square = new Square(2);
        int perimeter = square.getPerimeter();
        assertEquals(8,square.getPerimeter());
    }

}