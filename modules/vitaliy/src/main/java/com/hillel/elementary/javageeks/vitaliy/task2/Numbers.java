package com.hillel.elementary.javageeks.vitaliy.task2;


import java.util.Scanner;


public class Numbers {

    public static void main(String[] args) {
        System.out.println("Введите число - как много переменных вы хотите добавить в массив и нажмите <Enter>:");
        Scanner scan = new Scanner(System.in);
        int chisloNaVhode = scan.nextInt();
        int massiv[] = new int[chisloNaVhode];
        int numbers[] = new int[chisloNaVhode];
        System.out.println();
        System.out.println("Сейчас введите ваши числа через пробел и нажмите <Enter>:");
        for (int i = 0; i < chisloNaVhode; i++) {
            massiv[i] = scan.nextInt();
            numbers[i] = (massiv[i] + "").length();
        }
        scan.close();
        numbersLength(massiv, numbers, chisloNaVhode);

    }

    private static void numbersLength(int[] massiv, int[] numbers, int chisloNaVhode) {
        int max = numbers[0], min = numbers[0], big = 0, small = 0;
        for (int i = 1; i < chisloNaVhode; i++) {
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
        System.out.println("самое короткое число: " + massiv[small] + "." + " Его длина: " + min + ";");
        System.out.println("самое длинное число: " + massiv[big] + "." + " Его длина: " + max + ";");
    }
}