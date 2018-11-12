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

  private double area;
  private double perimeter;

  private boolean isEquilateral; //равносторонний
  private boolean isIsosceles; //равнобедренный
  private boolean isRectangular; //прямоугольный
  private boolean isArbitrary; //произвольный

  public Triangle(Vertex vertexA, Vertex vertexB, Vertex vertexC) throws VertexOverlapException{
    checkForVertexOverlap(vertexA, vertexB, vertexC);

    this.vertexA = vertexA;
    this.vertexB = vertexB;
    this.vertexC = vertexC;

    calculateProperties();
  }

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

  public void setVertexA(Vertex vertexA) throws VertexOverlapException{
    checkForVertexOverlap(vertexA, vertexB, vertexC);
    this.vertexA = vertexA;
  }

  public Vertex getVertexB() {
    return vertexB;
  }

  public void setVertexB(Vertex vertexB)  throws VertexOverlapException{
    checkForVertexOverlap(vertexA, vertexB, vertexC);
    this.vertexB = vertexB;
  }

  public Vertex getVertexC() {
    return vertexC;
  }

  public void setVertexC(Vertex vertexC)  throws VertexOverlapException{
    checkForVertexOverlap(vertexA, vertexB, vertexC);
    this.vertexC = vertexC;
  }

  public boolean isEquilateral() {
    return isEquilateral;
  }

  public boolean isIsosceles() {
    return isIsosceles;
  }

  public boolean isRectangular() {
    return isRectangular;
  }

  public boolean isArbitrary() {
    return isArbitrary;
  }

  public double getArea(){
    return area;
  }

  public double getPerimeter(){
    return perimeter;
  }

  public void calculateProperties() {
    area = 0.5 * Math.abs((vertexA.getX()-vertexC.getX())*(vertexB.getY()-vertexC.getY()) -
            (vertexB.getX()-vertexC.getX())*(vertexA.getY()-vertexC.getY()));

    double ab =  calculateLineLength(vertexA, vertexB);
    double bc =  calculateLineLength(vertexB, vertexC);
    double ac =  calculateLineLength(vertexA, vertexC);

    perimeter = ab + bc + ac;

    isEquilateral = ab == bc && bc == ac && ac == ab; //равносторонний
    isIsosceles = ab == bc || bc == ac ||  ac == ab; //равнобедренный
    isRectangular = (Math.pow(ab, 2) + Math.pow(bc, 2) == Math.pow(ac, 2)) //прямоугольный
            || (Math.pow(bc, 2) + Math.pow(ac, 2) == Math.pow(ab, 2))
            || (Math.pow(ac, 2) + Math.pow(ab, 2) == Math.pow(bc, 2));
    isArbitrary = !isEquilateral && !isIsosceles && !isRectangular; //произвольный
  }

  private double calculateLineLength(Vertex vOne, Vertex vTwo){
    return Math.sqrt(Math.pow(vOne.getX()-vTwo.getX(), 2) +
            Math.pow(vOne.getY()-vTwo.getY(), 2));
  }

  private void checkForVertexOverlap(Vertex vertexA, Vertex vertexB, Vertex vertexC) throws  VertexOverlapException{
    if (vertexA.equals(vertexB) || vertexB.equals(vertexC) || vertexC.equals(vertexA))
      throw new VertexOverlapException(vertexA, vertexB, vertexC);
  }
}
