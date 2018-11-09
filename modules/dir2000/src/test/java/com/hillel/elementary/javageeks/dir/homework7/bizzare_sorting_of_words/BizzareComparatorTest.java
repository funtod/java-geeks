package com.hillel.elementary.javageeks.dir.homework7.bizzare_sorting_of_words;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BizzareComparatorTest {

  @Test
  void compare() {
  }

  @Test
  void equals() {
    //given
    BizzareComparator comparatorOne = new BizzareComparator();
    BizzareComparator comparatorTwo = new BizzareComparator();

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
    int result = BizzareComparator.vowelLettersCount(word);

    //then
    assertThat(result).isEqualTo(10);
  }
}