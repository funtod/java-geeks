/*JG-47
  Определить класс Треугольник на плоскости.
  Определить площадь и периметр треугольника.
  Создать массив/список/множество объектов и подсчитать количество треугольников разного типа
  (равносторонний, равнобедренный, прямоугольный, произвольный).
  Определить для каждой группы наибольший и наименьший по площади (периметру) объект.*/

package com.hillel.elementary.javageeks.dir.homework4.triangle;

import java.util.Objects;

public class Triangle {
  private Vertex vertexA;
  private Vertex vertexB;
  private Vertex vertexC;

  @Override
  public String toString() {
    return "Triangle{" +
            "vertexA=" + vertexA +
            ", vertexB=" + vertexB +
            ", vertexC=" + vertexC +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Triangle triangle = (Triangle) o;
    return Objects.equals(vertexA, triangle.vertexA) &&
            Objects.equals(vertexB, triangle.vertexB) &&
            Objects.equals(vertexC, triangle.vertexC);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vertexA, vertexB, vertexC);
  }

  public Vertex getVertexA() {
    return vertexA;
  }

  public void setVertexA(Vertex vertexA) {
    this.vertexA = vertexA;
  }

  public Vertex getVertexB() {
    return vertexB;
  }

  public void setVertexB(Vertex vertexB) {
    this.vertexB = vertexB;
  }

  public Vertex getVertexC() {
    return vertexC;
  }

  public void setVertexC(Vertex vertexC) {
    this.vertexC = vertexC;
  }

  public Triangle(Vertex vertexA, Vertex vertexB, Vertex vertexC) {
    this.vertexA = vertexA;
    this.vertexB = vertexB;
    this.vertexC = vertexC;
  }

  public double getArea(){
    return 0.5 * Math.abs((vertexA.getX()-vertexC.getX())*(vertexB.getY()-vertexC.getY()) -
            (vertexB.getX()-vertexC.getX())*(vertexA.getY()-vertexC.getY()));
  }

  public double getPerimeter(){
    /*АВ (с) = √((Хв-Ха)²+(Ув-Уа)²) = √4 = 2.
    BC (а)= √((Хc-Хв)²+(Ус-Ув)²) = √37 ≈ 6,08276253.
    AC (в) = √((Хc-Хa)²+(Ус-Уa)²) = √37 ≈ 6,08276253.*/
    double ab = Math.sqrt(Math.pow(vertexB.getX()-vertexA.getX(), 2) +
            Math.pow(vertexB.getY()-vertexA.getY(), 2));
    double bc = Math.sqrt(Math.pow(vertexC.getX()-vertexB.getX(), 2) +
            Math.pow(vertexC.getY()-vertexB.getY(), 2));
    double ac = Math.sqrt(Math.pow(vertexC.getX()-vertexA.getX(), 2) +
            Math.pow(vertexC.getY()-vertexA.getY(), 2));

    return ab + bc + ac;
  }
}
