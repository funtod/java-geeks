package com.hillel.elementary.javageeks.examples.classes.abstract_class;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void shouldCalculateArea() {
        Shape triangle = new Square(2);

        double area = triangle.getArea();

        assertEquals(area, 8, 0.01);
    }

}