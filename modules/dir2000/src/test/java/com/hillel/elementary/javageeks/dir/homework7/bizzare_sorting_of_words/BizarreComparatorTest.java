package com.hillel.elementary.javageeks.dir.homework7.bizzare_sorting_of_words;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BizarreComparatorTest {

  @Test
  void compare() {
    //given
    BizarreComparator comparator = new BizarreComparator();
    String stringOne = "foo";
    String stringTwo = "bar";

    //when
    int result = comparator.compare(stringOne, stringTwo);

    //then
    assertThat(result).isPositive();
  }

  @Test
  void equals() {
    //given
    BizarreComparator comparatorOne = new BizarreComparator();
    BizarreComparator comparatorTwo = new BizarreComparator();

    //when
    boolean result = comparatorOne.equals(comparatorTwo);

    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  void vowelLettersCount() {
    //given
    String word = "ULTRaREVOLUTioNARIE";

    //when
    int result = BizarreComparator.vowelLettersCount(word);

    //then
    assertThat(result).isEqualTo(10);
  }
}