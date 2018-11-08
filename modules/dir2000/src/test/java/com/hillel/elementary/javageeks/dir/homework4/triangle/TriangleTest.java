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
  void shouldTriangleSearch() throws VertexOverlapException {
    //given
    Triangle[] triangles = getTestedArray();

    //when
    TriangleSelector rectangularAreaSelector = new TriangleSelector() {
      @Override
      public boolean isSuitable(Triangle triangle) {
        return triangle.isRectangular();
      }
      @Override
      public double getValue(Triangle triangle) {
        return triangle.getArea();
      }
    };

    TriangleSearch search = TriangleSearch.performSearch(triangles, rectangularAreaSelector);
    Triangle minTriangle = new Triangle(new Vertex(44, 34), new Vertex(71, 11), new Vertex(44, 11));
    Triangle maxTriangle = new Triangle(new Vertex(19, 79), new Vertex(83, 47), new Vertex(63, 7));

    //then
    assertEquals(search.getMinTriangle(), minTriangle);
    assertEquals(search.getMaxTriangle(), maxTriangle);
    assertEquals(search.getCount(), 8);
  }

  Triangle[] getTestedArray() {
    Triangle[] triangles = new Triangle[10000];
    Random random = new Random(1984);
    int counter = 0;
    int upBound = 101;
    while (counter < triangles.length) {
      try {
        Triangle triangle = new Triangle(new Vertex(random.nextInt(upBound), random.nextInt(upBound)),
                new Vertex(random.nextInt(upBound), random.nextInt(upBound)),
                new Vertex(random.nextInt(upBound), random.nextInt(upBound)));
        triangles [counter] = triangle;
        counter++;
      } catch (VertexOverlapException e) {
        //it's not critical
      }
    }
    return triangles;
  }

}


