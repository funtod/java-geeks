package com.hillel.elementary.javageeks.ruslanTask6;

import java.io.*;
import java.net.URL;

public class ReadFileChangeFirstLetter {

    public static void main(String[] args) throws IOException, InterruptedException {
        URL resource =ReadFileChangeFirstLetter.class.getClassLoader ().getResource ("Test1.txt");
        String fileFrom = resource.getFile ();
 //       try {
            File filename = new File(fileFrom);
         FileInputStream inputStream;

        // Класс для работы потоком ввода в файл
         FileOutputStream outputStream;

                 // инициализируем поток вывода из файлу
            inputStream = new FileInputStream(fileFrom);

            // читаем первый символ с потока байтов
            int data = inputStream.read();
            char content;

            // если data будет равна 0 то это значит,
            // что файл пуст
        boolean fUper=false;
        while(data != -1) {
            // переводим байты в символ
            content = (char) data;

            // выводим полученный символ
            if (fUper) {
                System.out.print(String.valueOf(content).toUpperCase());
                fUper=false;
            }
            System.out.print(content);
            if (content==' '){
                fUper = true;
            }


            // читаем следующий байты символа
            data = inputStream.read();
        }

            // закрываем поток чтения файла
            inputStream.close();




    }


    public static void write(String st,String fileFrom) throws IOException {
        FileInputStream inputStream;

        // Класс для работы потоком ввода в файл
        FileOutputStream outputStream;
        // открываем поток ввода в файл
        outputStream = new FileOutputStream(fileFrom);

        // записываем данные в файл, но
        // пока еще данные не попадут в файл,
        // а просто будут в памяти
        outputStream.write(st.getBytes());

        // только после закрытия потока записи,
        // данные попадают в файл
        outputStream.close();
    }

}



