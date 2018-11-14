/* JG-89
Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
 Результат записать в файл с именем исходного плюс суфикс _swapped перед расширением
* */

package com.hillel.elementary.javageeks.dir.homework8.word_permutation;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Processor {
  static private final Pattern PATTERN = Pattern.compile("(.*?)(\\w+)((.*?\\s+.*?)+)(\\w+)(.*?)");

  public static File process(URL inputURL) throws Exception {
    File inputFile = new File(inputURL.getFile());
    File outputFile = getOutputFile(inputFile);
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8))) {
      try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8))) {
        StringBuilder builder = new StringBuilder();
        while (true) {
          String line = reader.readLine();
          if (line == null)
            break;
          Matcher matcher = PATTERN.matcher(line);
          if (matcher.matches()){
            builder.setLength(0);
            builder.append(matcher.group(1));
            builder.append(matcher.group(5));
            builder.append(matcher.group(3));
            builder.append(matcher.group(2));
            builder.append(matcher.group(6));
            writer.println(builder.toString());
          } else {
            writer.println(line);
          }
        }
      }
    }

    return outputFile;
  }

  private static File getOutputFile(File inputFile) throws Exception {
    String inputFileName = inputFile.getName();
    String prefix, suffix;
    int extensionPointIndex = inputFileName.lastIndexOf(".");
    if (extensionPointIndex == -1) {
      prefix = inputFileName;
      suffix = "";
    } else{
      prefix = inputFileName.substring(0, extensionPointIndex);
      suffix = inputFileName.substring(extensionPointIndex);
    }
    suffix = "_swapped" + suffix;

    return File.createTempFile(prefix, suffix);
  }
}
