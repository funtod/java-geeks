package com.hillel.elementary.javageeks.huffman_algorithm;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

final class FileReaderWriter {

    private FileReaderWriter() {
    }

    static String readStringFromFile(String filePath) {
        List<String> lines = null;
        StringBuilder fileText = new StringBuilder();

        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < lines.size(); i++) {
            if (i < lines.size() - 1) {
                fileText.append(lines.get(i) + "\n");
            } else {
                fileText.append(lines.get(i));
            }
        }

        return fileText.toString();
    }

    static void writeStringToFile(String text, String pathToFile) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathToFile)))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static byte[] readByteArrayFromFile(String pathToCompressedFile) {
        try {
            return Files.readAllBytes(new File(pathToCompressedFile).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void writeByteArrayToFile(String filePath, byte[] data) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))) {
            fileOutputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static HashMap<Character, String> readHashMapFromFile(String filePath) {
        HashMap<Character, String> hashMap = new HashMap<>();
        File file = new File(filePath);
        String line = "";
        StringBuilder fileText = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            fileText = new StringBuilder(bufferedReader.readLine());
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    fileText.append("\n").append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] keyValues = fileText.toString().split(";");
        for (String keyValue : keyValues) {
            String[] pair = keyValue.split(":");
            hashMap.put(pair[0].charAt(0), pair[1]);
        }
        return hashMap;
    }

    static void writeHashMapToFile(String filePath, HashMap<Character, String> hashMap) {
        StringBuilder fileData = new StringBuilder();
        Character[] characters = new Character[hashMap.keySet().size()];
        hashMap.keySet().toArray(characters);
        for (int i = 0; i < characters.length; i++) {
            fileData.append(characters[i]).append(":").append(hashMap.get(characters[i]));
            if (i < characters.length - 1) {
                fileData.append(";");
            }
        }
        writeStringToFile(fileData.toString(), filePath);
    }
}
