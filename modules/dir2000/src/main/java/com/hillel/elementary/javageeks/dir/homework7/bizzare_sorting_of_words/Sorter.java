/* JG-79
 Все слова текста рассортировать в порядке убывания их длин, при этом все слова
 одинаковой длины рассортировать в порядке возрастания в них количества гласных букв.*/

package com.hillel.elementary.javageeks.dir.homework7.bizzare_sorting_of_words;

import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.function.IntFunction;

public class Sorter {
  protected Sorter() {
  }

  public static String[] sortWords(String source) {
    StringTokenizer tokenizer = new StringTokenizer(source, ".,:-!? \t\n\r\f\"");

    return Collections.list(tokenizer).stream()
            .map(token -> (String) token)
            .sorted(new BizarreComparator())
            .toArray(String[]::new);
  }
}
