/* JG-89
Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
 Результат записать в файл с именем исходного плюс суфикс _swapped перед расширением
* */

package com.hillel.elementary.javageeks.dir.homework8.word_permutation;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Processor {
  public static File process(URL inputURL) throws Exception {
    File inputFile = new File(inputURL.getFile());
    File outputFile = getOutputFile(inputFile);
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8))) {
      try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8))) {
        while (true) {
          String line = reader.readLine();
          if (line == null)
            break;
          writer.println(line);
        }
      }
    }

    return outputFile;
  }

  private static File getOutputFile(File inputFile) throws Exception {
    String inputFileName = inputFile.getName();
    String prefix = inputFileName;
    String suffix = "";
    int extensionPointIndex = inputFileName.lastIndexOf(".");
    if (extensionPointIndex >= 0) {
      prefix = inputFileName.substring(0, extensionPointIndex);
      suffix = inputFileName.substring(extensionPointIndex);
    }
    prefix += "_swapped";

    return File.createTempFile(prefix, suffix);
  }
}
