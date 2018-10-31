package com.hillel.elementary.javageeks.dir.homework4.triangle;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

  @Test
  void shouldCalculateArea() throws VertexOverlapException {
    //given
    Triangle triangle = new Triangle(new Vertex(2, -3), new Vertex(1, 1), new Vertex(-6, 5));

    //when
    double area = triangle.getArea();

    //then
    assertEquals(area, 12.0);
  }

  @Test
  void shouldCalculatePerimeter() throws VertexOverlapException {
    //given
    Triangle triangle = new Triangle(new Vertex(-1, 4), new Vertex(-1, 2), new Vertex(-7, 3));

    //when
    double perimeter = triangle.getPerimeter();

    //then
    assertEquals(perimeter, 14.16, 0.01);
  }

  @Test
  void shouldCalculateStatistics() {
    //given
    Triangle[] triangles = getTestedArray();

    //when
    TriangleSelector selector = new TriangleSelector() {
      @Override
      public boolean isSuitable(Triangle triangle) {
        return triangle.isRectangular();
      }
      @Override
      public double getValue(Triangle triangle) {
        return triangle.getArea();
      }
    };

    TriangleSearch search = TriangleSearch.performeSearch(triangles, selector);

    //then
    System.out.println(search);
    //    assertEquals(perimeter, 14.16, 0.01);
  }

  Triangle[] getTestedArray() {
    Triangle[] triangles = new Triangle[100];
    Random random = new Random(1984);
    int counetr = 0;
    while (counetr < triangles.length) {
      try {
        Triangle triangle = new Triangle(new Vertex(random.nextInt(), random.nextInt()),
                new Vertex(random.nextInt(), random.nextInt()),
                new Vertex(random.nextInt(), random.nextInt()));
        triangles [counetr] = triangle;
        counetr++;
      } catch (VertexOverlapException e) {
      }
    }
    return triangles;
  }

}


