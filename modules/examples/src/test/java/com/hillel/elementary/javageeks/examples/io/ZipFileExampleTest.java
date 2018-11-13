package com.hillel.elementary.javageeks.examples.io;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;

class ZipFileExampleTest {

    @Test
    void shouldZipAFile() throws IOException {
        String name = "pride_and_prejudice.txt";
        String fileFrom = new File(FileCopyExampleTest.class.getClassLoader().getResource(name).getFile()).getAbsolutePath();
        String zipTo = File.createTempFile("pride_and_prejudice", ".zip").getAbsolutePath();

        ZipFileExample.zip(fileFrom, zipTo, name);

        System.out.println(zipTo);

        String content = getZipContent(name, zipTo);
        assertThat(content).isEqualTo(new String(Files.readAllBytes(Paths.get(fileFrom))));
    }

    private String getZipContent(String name, String zipTo) throws IOException {
        ZipFile zipFile = new ZipFile(zipTo);
        ZipEntry entry = zipFile.getEntry(name);

        InputStream inputStream = zipFile.getInputStream(entry);
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int read = 0;
        while ((read = inputStream.read(buffer, 0, buffer.length)) > 0)
            baos.write(buffer, 0, read);
        return baos.toString();
    }
}