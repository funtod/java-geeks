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

  public Fraction(int argNumerator, int argDenominator) {
    if (argDenominator == 0) {
      throw new IllegalArgumentException("/ by zero");
    }
    this.numerator = argNumerator;
    this.denominator = argDenominator;
  }

  public Fraction(Fraction other) {
    numerator = other.numerator;
    denominator = other.denominator;
  }

  @Override
  public final String toString() {
    return "Fraction{"
            + "numerator=" + numerator
            + ", denominator=" + denominator
            + '}';
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fraction fraction = (Fraction) o;
    return numerator == fraction.numerator
            && denominator == fraction.denominator;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(numerator, denominator);
  }

  public final int getNumerator() {
    return numerator;
  }

  public final void setNumerator(int argNumerator) {
    this.numerator = argNumerator;
  }

  public final int getDenominator() {
    return denominator;
  }

  public final void setDenominator(int argDenominator) {
    if (argDenominator == 0) {
      throw new IllegalArgumentException("/ by zero");
    }
    this.denominator = argDenominator;
  }

  public final double getDoubleValue() {
    return ((double) numerator) / denominator;
  }

  public final void addValues(Fraction other) {
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
