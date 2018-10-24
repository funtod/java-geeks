package com.hillel.elementary.javageeks.oleg.my_labs.lab_2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Polindrom {
    //Метод для разделения строки на отдельные числа
    public static String[] token(String numbers) {
        //Создаем обьект типа StringTokenizer, со знаками разделения "," и "_"
        StringTokenizer num = new StringTokenizer(numbers, ", ");
        //Подсчитываем к-во чисел для создания массива
        int count = num.countTokens();
        //Создаем массив
        String[] numText = new String[count];
        //Заполняем массив числами
        for (int i=0; i<numText.length; i++) {
            numText[i] = num.nextToken();
        }
        return numText;
    }
    //Метод для вывода на консоль палиндрома
    public static void toCheckPalindromNumber(String[] nums) {

        for (int i=0; i<nums.length; i++) {
            try {
                //Пытаемся привести строковое значение к целочисленному
                int a = Integer.parseInt(nums[i]);
                //Если получается, проверяем является ли число палиндромом
                if (checkNumbers(a)) {
                    System.out.println("Число "+a+" является палиндромом");
                }
            } catch (NumberFormatException e) {
                //В случае если строку нельзя привести к целочисленному значению
                //проверяем можно ли ее привести к вещественному
                try {
                    double b = Double.parseDouble(nums[i]);
                    //Если получается, проверяем является ли число палиндромом
                    if (checkNumbers(b)) {
                        System.out.println("Число "+b+" является палиндромом");
                    }
                    //Если нет, тогда в строке текст
                } catch (NumberFormatException f) {
                    System.out.println("Введенное вами выражение '"+nums[i]+
                            "' не является целым или вещественным числом");
                }
            }
        }
    }
    //Метод который, в общем то, проверяет является ли целое
    //или вещественное число палиндромом
    public static boolean checkNumbers(int num) {
        char[] x = String.valueOf(num).toCharArray();
        boolean check = true;
        for (int i=0, j=x.length-1; i < x.length; i++, j--) {
            if (x[i] == x[j]) {
                check = true;
            } else {
                return false;
            }
        }
        return check;
    }
    //Перегружаем метод для проверки вещественных чисел
    public static boolean checkNumbers(double num) {
        char[] x = String.valueOf(num).toCharArray();
        boolean check = true;
        for (int i=0, j=x.length-1; i < x.length; i++, j--) {
            if (x[i] == x[j]) {
                check = true;
            } else {
                return false;
            }
        }
        return check;
    }

    public static void main(String[] args) {

        System.out.println("Введите необходимое количество чисел");
        System.out.println("Введите все числа в одну строку разделяя запятой");
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        String[] a = token(numbers);
        toCheckPalindromNumber(a);
    }
}
