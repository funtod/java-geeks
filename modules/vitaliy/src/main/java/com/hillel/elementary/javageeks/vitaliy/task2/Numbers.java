package com.hillel.elementary.javageeks.vitaliy.task2;


import java.util.Scanner;


public class Numbers {

    public static void main(String[] args) {
        System.out.println("Введите число - как много переменных вы хотите добавить в массив и нажмите <Enter>:");
        Scanner scan = new Scanner(System.in);
        int numberIn = scan.nextInt();
        int massive[] = new int[numberIn];
        int numbers[] = new int[numberIn];
        System.out.println();
        System.out.println("Сейчас введите ваши числа через пробел и нажмите <Enter>:");
        for (int i = 0; i < numberIn; i++) {
            massive[i] = scan.nextInt();
            numbers[i] = (massive[i] + "").length();
        }
        scan.close();
        numbersLength(massive, numbers, numberIn);

    }

    private static void numbersLength(int[] massive, int[] numbers, int numberIn) {
        int max = numbers[0], min = numbers[0], big = 0, small = 0;
        for (int i = 1; i < numberIn; i++) {
            int j = numbers[i];
            if (min > j) {
                min = j;
                small = i;
            } else {
                if (max < j) {
                    max = j;
                    big = i;
                }
            }
        }
        System.out.println();
        System.out.println("*********************************");
        System.out.println();
        System.out.println("самое короткое число: " + massive[small] + "." + " Его длина: " + min + ";");
        System.out.println("самое длинное число: " + massive[big] + "." + " Его длина: " + max + ";");
    }
}