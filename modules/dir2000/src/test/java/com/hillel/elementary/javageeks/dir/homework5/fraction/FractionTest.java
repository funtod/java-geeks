package com.hillel.elementary.javageeks.dir.homework5.fraction;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FractionTest {
  @Test
  public void shouldThrowExceptionOnCreationWithZeroDenominator(){
    assertThatThrownBy(() -> {new Fraction(8, 0);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void shouldThrowExceptionOnSettingZeroDenominator(){
    //given
    Fraction fraction = new Fraction(8, 3);

    //then
    assertThatThrownBy(() -> {fraction.setDenominator(0);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void shouldFulfillTheConditionsOfTheTask() throws Exception {
    //given
    Fraction fourIndexFraction = new Fraction(5, 11);

    //Создать массив/список/множество объектов...
    LinkedList<Fraction> list = new LinkedList<>();
    list.add(new Fraction(4, 7));
    list.add(new Fraction(5, 3));
    list.add(new Fraction(1, 2));
    list.add(new Fraction(1, 2));
    list.add(fourIndexFraction);

    /*...и передать его в метод, который изменяет каждый
    элемент массива с четным индексом путем добавления следующего за ним элемента*/
    List<Fraction> modifiedList = Fractions.modifyFractions(list);

    //then
    assertThat(modifiedList.get(2).getDoubleValue()).isEqualTo(1D);
    //should stay the same, because there isn't the next element
    assertThat(modifiedList.get(4)).isEqualTo(fourIndexFraction);
  }
}
