/* JG-50
 Объявить и инициализировать массив из k дробей, ввести/вывести значения для массива дробей.
 Создать массив/список/множество объектов и передать его в метод, который изменяет каждый
 элемент массива с четным индексом путем добавления следующего за ним элемента*/

package com.hillel.elementary.javageeks.dir.homework5.fraction;

import java.util.Objects;
import java.math.BigInteger;

public class Fraction {
  private int numerator;
  private int denominator;

  public Fraction(int numerator, int denominator){
    if (denominator == 0)
      throw new IllegalArgumentException("/ by zero");
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Fraction(Fraction other){
    numerator = other.numerator;
    denominator = other.denominator;
  }

  @Override
  public String toString() {
    return "Fraction{" +
            "numerator=" + numerator +
            ", denominator=" + denominator +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Fraction fraction = (Fraction) o;
    return numerator == fraction.numerator &&
            denominator == fraction.denominator;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numerator, denominator);
  }

  public int getNumerator() {
    return numerator;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setDenominator(int denominator){
    if (denominator == 0)
      throw new IllegalArgumentException("/ by zero");
    this.denominator = denominator;
  }

  public double getDoubleValue() {
    return ((double) numerator) / denominator;
  }

  public void addValues(Fraction other) {
    numerator = numerator * other.denominator + denominator * other.numerator;
    denominator = denominator * other.denominator;

    BigInteger b1 = BigInteger.valueOf(numerator);
    BigInteger b2 = BigInteger.valueOf(denominator);
    int greatestCommonDivisor = b1.gcd(b2).intValue();
    if (greatestCommonDivisor != 0) {
      numerator /= greatestCommonDivisor;
      denominator /= greatestCommonDivisor;
    }
  }
}
