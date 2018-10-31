package com.hillel.elementary.javageeks.dir.homework4.triangle;

public class TriangleSearch {
  private int count;
  private Triangle minTriangle;
  private Triangle maxTriangle;

  public static TriangleSearch performSearch(Triangle [] array, TriangleSelector selector){
    double minValue = Double.MAX_VALUE;
    double maxValue = Double.MIN_VALUE;

    TriangleSearch search = new TriangleSearch();

    for (Triangle triangle: array) {
      if (selector.isSuitable(triangle)) {
        search.count++;

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

  public Triangle getMaxTriangle() {
    return maxTriangle;
  }

  public Triangle getMinTriangle() {
    return minTriangle;
  }

  @Override
  public String toString() {
    return "TriangleSearch{" +
            "count=" + count +
            ", minTriangle=" + minTriangle +
            ", maxTriangle=" + maxTriangle +
            '}';
  }

  public int getCount() {
    return count;
  }
}
