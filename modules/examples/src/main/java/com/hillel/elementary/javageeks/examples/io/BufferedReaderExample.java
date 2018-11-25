package com.hillel.elementary.javageeks.examples.io;

import java.io.*;
import java.net.URL;
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

            StringBuilder stringBuilder = new StringBuilder();

            for (String line = reader.readLine(); line != null && !line.equals("q"); line = reader.readLine()) {
                stringBuilder.append(line);
                writer.println(line);
            }



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

    public static void main(String[] args) throws IOException {
        URL resource = BufferedReaderExample.class.getClassLoader().getResource("pride_and_prejudice.txt");
        run(resource.openStream(), System.out);

        File file = new File(resource.getFile());


    }
}
