package com.hillel.elementary.javageeks.dir.homework7.bizzare_sorting_of_words;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BizzareComparator implements Comparator<String> {
  private static Pattern pattern = Pattern.compile("[aeiouyAEIOUY]{1}");

  public static int vowelLettersCount(String word){
    Matcher matcher = pattern.matcher(word);
    int counter = 0;
    while(matcher.find())
      counter++;
    return  counter;
  }

  @Override
  public int compare(String stringOne, String stringTwo) {
    if (stringOne == null && stringTwo == null)
      return 0;
    if (stringOne == null)
      return -1;
    if (stringOne.equals(stringTwo))
      return 0;

    int oneLenght = stringOne.length();
    int twoLenght = stringTwo.length();

    if (oneLenght != twoLenght)
            return twoLenght - oneLenght;

    int vowelsCountOne = vowelLettersCount(stringOne);
    int vowelsCountTwo = vowelLettersCount(stringTwo);

    return vowelsCountOne - vowelsCountTwo;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    return true;
  }
}
