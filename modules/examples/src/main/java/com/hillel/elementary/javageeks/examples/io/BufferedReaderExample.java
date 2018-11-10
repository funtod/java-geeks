package com.hillel.elementary.javageeks.examples.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BufferedReaderExample {

    public static void run(InputStream inputStream, OutputStream outputStream) {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            writer = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
            //true –означает, что после вызова writer.println(…) можно не вызывать writer.flush().

            String text = "Hello, World";
            writer.printf("PrintWriter puts: %s\n", text);

            writer.println("Character input:");

            for (int letter = reader.read(); letter != -1 && letter != 'q'; letter = reader.read())
                writer.println((char) letter);

            writer.println("Line input:");

            for (String line = reader.readLine(); !line.equals("q"); line = reader.readLine())
                writer.println(line);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) writer.close();
        }
    }
}
