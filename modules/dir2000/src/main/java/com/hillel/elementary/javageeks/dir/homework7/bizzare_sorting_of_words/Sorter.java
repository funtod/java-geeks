/* JG-79
 Все слова текста рассортировать в порядке убывания их длин, при этом все слова
 одинаковой длины рассортировать в порядке возрастания в них количества гласных букв.*/

package com.hillel.elementary.javageeks.dir.homework7.bizzare_sorting_of_words;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Sorter {
  protected Sorter() {
  }

  public static String[] sortWords(String source) {
    StringTokenizer tokenizer = new StringTokenizer(source, ".,:-!? \t\n\r\f\"");
    String[] array = new String[tokenizer.countTokens()];

    int counter = 0;
    while (tokenizer.hasMoreTokens()) {
      array[counter++] = tokenizer.nextToken();
    }

    Arrays.sort(array, new BizarreComparator());
    return array;
  }
}
