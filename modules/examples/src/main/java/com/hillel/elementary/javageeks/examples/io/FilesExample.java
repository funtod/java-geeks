package com.hillel.elementary.javageeks.examples.io;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class FilesExample {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true)) {
            File file = new File(FilesExample.class.getClassLoader().getResource("pride_and_prejudice.txt").getFile());

            writer.println();
            writer.printf("Файл \"%s\"%s существует\n", file.getName(), file.exists() ? "" : " не");
            writer.printf("Вы%s можете читать файл\n", file.canRead() ? "" : " не");
            writer.printf("Вы%s можете записывать в файл\n", (file.canWrite() ? "" : " нe"));
            writer.printf("Длина файла %dб\n", file.length());

            File d = new File("/");
            writer.println("Содержимое каталога:");

            if (d.exists() && d.isDirectory()) {
                String[] s = d.list();
                for (String value : s)
                    writer.println(value);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
