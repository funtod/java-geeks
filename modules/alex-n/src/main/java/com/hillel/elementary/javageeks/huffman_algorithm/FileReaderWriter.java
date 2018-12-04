package com.hillel.elementary.javageeks.huffman_algorithm;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class FileReaderWriter {

    public static String readStringFromFile(String filePath) {
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

    public static void writeStringToFile(String text, String pathToFile) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathToFile)))) {
            writer.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readByteArrayFromFile(String pathToCompressedFile) {
        try {
            return Files.readAllBytes(new File(pathToCompressedFile).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeByteArrayToFile(String filePath, byte[] data) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))) {
            fileOutputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Character, String> readHashMapFromFile(String filePath) {
        HashMap<Character, String> hashMap = new HashMap<>();
        File file = new File(filePath);
        String line = "";
        String fileText = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            fileText = bufferedReader.readLine();
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    fileText += "\n" + line;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] keyValues = fileText.split(";");
        for (int i = 0; i < keyValues.length; i++) {
            String[] pair = keyValues[i].split(":");
            hashMap.put(pair[0].charAt(0), pair[1]);
        }
        return hashMap;
    }

    public static void writeHashMapToFile(String filePath, HashMap<Character, String> hashMap) {
        String fileData = "";
        Character[] characters = new Character[hashMap.keySet().size()];
        hashMap.keySet().toArray(characters);
        for (int i = 0; i < characters.length; i++) {
            fileData += characters[i] + ":" + hashMap.get(characters[i]);
            if (i < characters.length - 1) {
                fileData += ";";
            }
        }
        writeStringToFile(fileData, filePath);
    }
}
