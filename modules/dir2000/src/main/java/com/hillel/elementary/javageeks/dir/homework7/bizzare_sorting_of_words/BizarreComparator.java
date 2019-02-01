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
    Matcher matcher = PATTERN.matcher(word);
    int counter = 0;

    List<String> list = new ArrayList<>();
    while (matcher.find()) {
      list.add(word.substring(matcher.start(), matcher.end()));
      counter++;
    }
    String[] array = list.toArray(new String[list.size()]);
    System.out.println("Word: " + word);
    System.out.println("Ususal result: " + Arrays.deepToString(array));

    int streamCounter = vowelLettersCountStream(word);
    System.out.println("Stream check: " + counter + " == " + streamCounter + " = " + (counter == streamCounter) + "\n");

    return counter;
  }

  private static int vowelLettersCountStream(String word) {
    Pattern antiPattern = Pattern.compile("[^aeiouyAEIOUY]");
    Stream<String> stream = antiPattern.splitAsStream(word)
            .filter(val -> !val.isEmpty());

    Object[] array = stream.toArray();
    System.out.println("Stream result: " + Arrays.deepToString(array));
    int streamCounter = array.length;
    return streamCounter;
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
