package com.hillel.elementary.oleh.taskJg76;


public class Compile  {
    String compressAlternate(String str) {
        /* Проверяем, вдруг сжатие создаст более длинную строку */
        int size = countCompression(str);
        if (size >= str.length()) {
            return str;
        }

        char[] array = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) { // Найдите повторяющийся символ
                count++;
            }	else {
                /* Обоновляем счетчик повторяющихся символов */
                index = setChar(str, array, last, index, count);
                last = str.charAt(i);
                count = 1;
            }
        }

        /* Обновляем строку с последним набором повторяющихся символов */
        index = setChar(str, array, last, index, count);
        return String.valueOf(array);
    }

    int  setChar(String str, char[] array, char c, int index, int count) {
        array[index] = c;
        index++;

        /* Конвертируем счетчик в строку */
        char[] cnt = String. valueOf (count) .toCharArray();

        /* Копируем символы от большего разряда к меньшему */
        for (char х : cnt) {
            array[index] = х;
            index++;
        }
        return index;
    }

    int countCompression(String str) {
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else	{
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }
}