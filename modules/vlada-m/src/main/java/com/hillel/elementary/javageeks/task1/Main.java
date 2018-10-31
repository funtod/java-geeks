package com.hillel.elementary.javageeks.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please, enter the first integer:");
        int firstInteger = keyboard.nextInt();
        System.out.println("Please, enter the second integer:");
        int secondInteger = keyboard.nextInt();
        System.out.println("The sum =" + " " +summingMethod(firstInteger, secondInteger));
        System.out.println("The difference =" + " " + differenceMethod(firstInteger, secondInteger));
        System.out.println("The product =" + " " + productMethod(firstInteger, secondInteger));
        System.out.println("The average =" + " " + averageMethod(firstInteger, secondInteger));
        System.out.println("The distance =" + " " + Math.abs(firstInteger - secondInteger));
        System.out.println("The maximum =" + " " + Math.max(firstInteger, secondInteger));
        System.out.println("The minimum =" + " " + Math.min(firstInteger, secondInteger));
        keyboard.close();
    }

    public static int summingMethod(int firstInteger, int secondInteger) {
        return firstInteger + secondInteger;
    }

    public static int differenceMethod(int firstInteger, int secondInteger) {
        return firstInteger - secondInteger;
    }

    public static int productMethod(int firstInteger, int secondInteger) {
        return firstInteger * secondInteger;
    }

    public static int averageMethod(int firstInteger, int secondInteger) {
        return (firstInteger + secondInteger) / 2;
    }
}
