package com.hillel.elementary.javageeks.quadrangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RhombusTest {
    @Test
    void shouldCalculateArea(){
        Quadrilateral rhombus = new Rhombus(3,4);
        double area = rhombus.getArea();
        assertEquals(6,rhombus.getArea());
    }
    @Test
    void shouldCalculatePerimeter(){
        Quadrilateral rhombus = new Rhombus(5,10);
        int perimeter = rhombus.getPerimeter();
        assertEquals(20,rhombus.getPerimeter());

    }

}