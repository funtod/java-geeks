package com.hillel.elementary.javageeks.dir.homework7.bizzare_sorting_of_words;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SorterTest {

  @Test
  void sortWords() {
    //given
    String phrase = "Oh my God! - exclaimed the queen. - I am pregnant, and it is not known from whom!";

    //when
    String [] array = Sorter.sortWords(phrase);

    //then
    System.out.println(Arrays.deepToString(array));
    //assertThat()
  }
}