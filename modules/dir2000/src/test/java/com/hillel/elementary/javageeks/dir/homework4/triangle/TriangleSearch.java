package com.hillel.elementary.javageeks.dir.homework4.triangle;

public class TriangleSearch {
  private Triangle minTriangle;
  private Triangle maxTriangle;

  @Override
  public String toString() {
    return "TriangleSearch{" +
            "minTriangle=" + minTriangle +
            ", maxTriangle=" + maxTriangle +
            '}';
  }

  public static TriangleSearch performeSearch(Triangle [] array, TriangleSelector selector){
    double minValue = Double.MAX_VALUE;
    double maxValue = Double.MIN_VALUE;

    TriangleSearch search = new TriangleSearch();

    for (Triangle triangle: array) {
      if (selector.isSuitable(triangle)) {
        double value = selector.getValue(triangle);

        if (value < minValue) {
          minValue = value;
          search.minTriangle = triangle;
        }

        if (value > maxValue) {
          maxValue = value;
          search.maxTriangle = triangle;
        }
      }
    }

    return search;
  }
}
