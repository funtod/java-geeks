package com.hillel.elementary.javageeks.dir.homework5.fraction;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class FractionTest {
  @Test
  public void shouldThrowArithmeticExceptionOnCreationWithZeroDenominator(){
    //given
    Fraction fraction = null;

    //when
    try {
      fraction = new Fraction(8, 0);
    } catch (ArithmeticException e) {
    }

    //then
    assertThat(fraction).isNull();
  }

  @Test
  public void shouldThrowArithmeticExceptionOnSettingZeroDenominator(){
    //given
    Fraction fraction = new Fraction(8, 3);

    //when
    try {
      fraction.setDenominator(0);
    } catch (ArithmeticException e) {
    }

    //then
    assertThat(fraction.getDenominator()).isEqualTo(3);
  }

  @Test
  public void shouldFulfillTheConditionsOfTheTask(){
    //given
    Fraction twoIndexFraction = new Fraction(1, 2);
    Fraction fourIndexFraction = new Fraction(5, 11);
    Fraction clonedFourIndexFraction = new Fraction(fourIndexFraction);

    //Создать массив/список/множество объектов...
    LinkedList<Fraction> list = new LinkedList<>();
    list.add(new Fraction(4, 7));
    list.add(new Fraction(5, 3));
    list.add(twoIndexFraction);
    list.add(new Fraction(1, 2));
    list.add(fourIndexFraction);

    /*...и передать его в метод, который изменяет каждый
    элемент массива с четным индексом путем добавления следующего за ним элемента*/
    modifyFractionList(list);

    //then
    assertThat(twoIndexFraction.getDoubleValue()).isEqualTo(1D);
    //should stay the same, because there isn't the next element
    assertThat(fourIndexFraction).isEqualTo(clonedFourIndexFraction);
  }

  private void modifyFractionList(LinkedList<Fraction> list) {
    Iterator <Fraction> iterator = list.iterator();
    int currIndex = 0;
    while (iterator.hasNext()) {
      Fraction currFraction = iterator.next();
      if (currIndex > 0 && (currIndex) % 2 == 0 && iterator.hasNext()) {
        Fraction nextFraction = iterator.next();
        currFraction.add(nextFraction);
      }
      currIndex++;
    }
  }

}
