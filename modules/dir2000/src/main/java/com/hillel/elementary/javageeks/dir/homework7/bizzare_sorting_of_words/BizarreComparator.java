package com.hillel.elementary.javageeks.dir.homework7.bizzare_sorting_of_words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BizarreComparator implements Comparator<String> {
  private static final Pattern PATTERN = Pattern.compile("[aeiouyAEIOUY]");

  public static int vowelLettersCount(String word) {
    return (int) Arrays.stream(word.split(""))
            .filter(letter -> PATTERN.matcher(letter).matches())
            .count();
  }

  @Override
  public final int compare(String stringOne, String stringTwo) {
    if (stringOne == null && stringTwo == null) {
      return 0;
    }
    if (stringOne == null) {
      return -1;
    }
    if (stringOne.equals(stringTwo)) {
      return 0;
    }

    int oneLength = stringOne.length();
    int twoLength = stringTwo.length();

    if (oneLength != twoLength) {
      return twoLength - oneLength;
    }

    int vowelsCountOne = vowelLettersCount(stringOne);
    int vowelsCountTwo = vowelLettersCount(stringTwo);

    return vowelsCountOne - vowelsCountTwo;
  }

  @Override
  public final int hashCode() {
    return 1;
  }

  @Override
  public final boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    return obj != null && getClass() == obj.getClass();
  }
}
