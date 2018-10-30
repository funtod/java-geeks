package com.hillel.elementary.javageeks.examples.classes.abstract_class;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void shouldCalculateArea() {
        Shape triangle = new Triangle(10, 4 ,7);

        double area = triangle.getArea();

        assertEquals(area, 10.92, 0.01);
    }

    @Test
    void shouldReturnNaNForInvalidTriangle() {
        Shape triangle = new Triangle(1, 0,0);

        double area = triangle.getArea();

        assertTrue(Double.isNaN(area));
    }

}