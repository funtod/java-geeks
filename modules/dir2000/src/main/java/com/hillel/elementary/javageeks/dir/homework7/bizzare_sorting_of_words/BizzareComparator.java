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
  public int compare(String o1, String o2) {
    if (o1 == null && o2 == null)
      return 0;
    if (o1 == null)
      return -1;
    if (o1.equals(o2))
      return 0;

    if (o1.length() != o2.length())
            return o1.compareTo(o2);
    int vowelsCountO1 = vowelLettersCount(o1);
    int vowelsCountO2 = vowelLettersCount(o2);

    if (vowelsCountO1 == vowelsCountO2)
      return o1.compareTo(o2);
    else
      return vowelsCountO1 - vowelsCountO2;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    return true;
  }
}
