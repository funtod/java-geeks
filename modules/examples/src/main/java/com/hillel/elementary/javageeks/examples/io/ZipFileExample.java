package com.hillel.elementary.javageeks.examples.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileExample {

    public static void zip(String filePath, String zipPath, String zipName) {

        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath))) {
            byte[] input = Files.readAllBytes(Paths.get(filePath));
            ZipEntry zipEntry = new ZipEntry(zipName);
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
