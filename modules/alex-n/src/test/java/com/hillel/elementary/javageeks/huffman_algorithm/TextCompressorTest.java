package com.hillel.elementary.javageeks.huffman_algorithm;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TextCompressorTest {

    @Test
    void shouldCompressEndDecompressSingleLineFile() throws IOException {
        String txt = "hello world!";

        Path tmpFile = Files.createTempFile("tmpFile", null);
        Path tmpCompressedFile = Files.createTempFile("tmpCompressedFile", null);
        Path tmpKeyFile = Files.createTempFile("tmpKeyFile", null);
        Path tmpDecompressedFile = Files.createTempFile("tmpDecompressedFile", null);

        Files.write(tmpFile.toAbsolutePath(), Collections.singleton(txt));

        FileCompressor.compress(tmpFile.toString(), tmpCompressedFile.toString(), tmpKeyFile.toString());
        FileCompressor.decompress(tmpCompressedFile.toString(), tmpKeyFile.toString(), tmpDecompressedFile.toString());

        String decompressedFileText = Files.readAllLines(tmpDecompressedFile.toAbsolutePath()).get(0);

        assertThat(decompressedFileText).isEqualTo(txt);
    }

    @Test
    void shouldCompressEndDecompressMultiplyLineFile() throws IOException {
        String txt = "hello world!\nhello planet!\nhello continent!";

        Path tmpFile = Files.createTempFile("tmpFile", null);
        Path tmpCompressedFile = Files.createTempFile("tmpCompressedFile", null);
        Path tmpKeyFile = Files.createTempFile("tmpKeyFile", null);
        Path tmpDecompressedFile = Files.createTempFile("tmpDecompressedFile", null);

        FileUtils.writeStringToFile(tmpFile.toFile(), txt, "UTF-8");

        FileCompressor.compress(tmpFile.toString(), tmpCompressedFile.toString(), tmpKeyFile.toString());
        FileCompressor.decompress(tmpCompressedFile.toString(), tmpKeyFile.toString(), tmpDecompressedFile.toString());
        
        assertTrue (FileUtils.contentEquals(tmpFile.toFile(), tmpDecompressedFile.toFile()));
    }

    @Test
    void shouldCompressFileToSmallerFile() throws IOException {
        String txt = "hello world!\nhello planet!\nhello continent!";

        Path tmpFile = Files.createTempFile("tmpFile", null);
        Path tmpCompressedFile = Files.createTempFile("tmpCompressedFile", null);
        Path tmpKeyFile = Files.createTempFile("tmpKeyFile", null);

        FileUtils.writeStringToFile(tmpFile.toFile(), txt, "UTF-8");

        FileCompressor.compress(tmpFile.toString(), tmpCompressedFile.toString(), tmpKeyFile.toString());
        long uncompressedFileSize = new File(tmpFile.toString()).length();
        long compressedFileSize = new File(tmpCompressedFile.toString()).length();

        assertThat(uncompressedFileSize).isGreaterThan(compressedFileSize);
    }
}
