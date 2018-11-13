package com.hillel.elementary.javageeks.dir.homework7.bizzare_sorting_of_words;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SorterTest {

  @Test
  void sortWords() {
    //given
    String phrase = "Oh my God! - exclaimed the queen. - I am pregnant, and it is not known from whom!";
    String [] expected = {"exclaimed", "pregnant", "known", "queen", "from", "whom", "God", "the", "and", "not", "Oh", "my", "am", "it", "is", "I"};

    //when
    String [] result = Sorter.sortWords(phrase);

    //then
    assertThat(result).isEqualTo(expected);
  }
}