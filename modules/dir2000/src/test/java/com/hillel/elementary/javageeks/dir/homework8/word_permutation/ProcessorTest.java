package com.hillel.elementary.javageeks.dir.homework8.word_permutation;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {

  @Test
  void process()  throws Exception{
    //given
    URL inputURL = getClass().getClassLoader().getResource("1074-0.txt");

    //when
    File outputFile = Processor.process(inputURL);

    System.out.println(outputFile.getCanonicalPath());
  }
}