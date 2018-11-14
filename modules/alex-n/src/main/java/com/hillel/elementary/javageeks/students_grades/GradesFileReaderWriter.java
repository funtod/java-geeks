package com.hillel.elementary.javageeks.students_grades;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.*;

public class GradesFileReaderWriter {

    public String ReadGradesFromFile(String pathToFile){
        File file = new File(pathToFile);
        String line;
        StringBuilder stringBuilder = null;

        try(BufferedReader bufferedReader = new BufferedReader(
                                            new InputStreamReader(
                                            new FileInputStream(file), UTF_8))){

            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void WriteGradesToFile(String pathToFile, String text){
        File file = new File(pathToFile);

        try(BufferedWriter bufferedWriter = new BufferedWriter(
                                            new OutputStreamWriter(
                                            new FileOutputStream(file), UTF_8))){

            bufferedWriter.write(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
