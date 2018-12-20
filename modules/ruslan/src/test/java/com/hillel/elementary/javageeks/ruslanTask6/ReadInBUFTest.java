package com.hillel.elementary.javageeks.ruslanTask6;

import java.net.URL;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.*;

class ReadInBUFTest {

        @Test
        public void shouldResultReadFromFile() throws IOException {

        //given
        URL resource = ReadInBUF.class.getClassLoader().getResource("Test");
        String fileFrom = resource.getFile();
        File file = new File(fileFrom);

        ReadInBUF.WorkWithFile(file);

        String sCurrentLine = null;
            try (BufferedReader br = new BufferedReader(new FileReader(fileFrom))) {
                while ((sCurrentLine = br.readLine()) != null) {
                    String[] parts = sCurrentLine.split(" ");

                    int random = (int) (Math.random() * parts.length);

                    String lineOutput = "";
                    String checkResult = null;

                    if (sCurrentLine.length() > 0) {
                        char letter = parts[random].substring(0, 1).charAt(0);
                        if (letter >= 65 && letter <= 90) {
                            checkResult = "true";
                        } else {
                            checkResult = "false";
                        }
                    }
                    assertThat(checkResult).isEqualTo("true");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}