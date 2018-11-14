package com.hillel.elementary.javageeks.dir.homework8.word_permutation;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {

  @Test
  void process() throws Exception {
    //given
    URL inputURL = getClass().getClassLoader().getResource("1074-0.txt");
    URL expectedFileURL = getClass().getClassLoader().getResource("1074-0_swapped.txt");
    String expectedFileHash = getFileHash(Paths.get(expectedFileURL.toURI()).toFile());

    //when
    File outputFile = Processor.process(inputURL);
    String outputFileHash = getFileHash(outputFile);

    //then
    assertEquals(outputFileHash, expectedFileHash);
  }

  private String getFileHash(File file) throws Exception {
    MessageDigest alg = MessageDigest.getInstance("SHA-256");
    byte[] input = Files.readAllBytes(file.toPath());
    byte[] hash = alg.digest(input);

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < hash.length; i++) {
      int v = hash[i] & 0xFF;
      if (v < 16) builder.append("0");
      builder.append(Integer.toString(v, 16).toUpperCase());
      builder.append(" ");
    }
    return builder.toString();
  }
}