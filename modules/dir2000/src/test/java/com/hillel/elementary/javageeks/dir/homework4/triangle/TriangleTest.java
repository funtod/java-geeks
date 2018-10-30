package com.hillel.elementary.javageeks.dir.homework4.triangle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

  @Test
  void shouldCalculateArea() {
    Triangle triangle = new Triangle(new Vertex(2, -3), new Vertex(1, 1) ,new Vertex(-6, 5));

    double area = triangle.getArea();

    assertEquals(area, 12.0);
  }

  @Test
  void shouldCalculatePerimeter() {
    Triangle triangle = new Triangle(new Vertex(-1, 4), new Vertex(-1, 2) ,new Vertex(-7, 3));

    double perimeter = triangle.getPerimeter();

    assertEquals(perimeter, 14.16, 0.01);
  }

}
