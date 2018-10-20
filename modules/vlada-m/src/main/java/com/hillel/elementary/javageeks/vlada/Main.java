package com.hillel.elementary.javageeks.vlada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please, enter the first integer:");
        int firstInteger = keyboard.nextInt();
        System.out.println("Please, enter the second integer:");
        int secondInteger = keyboard.nextInt();
        int condition = 10;
        while (condition == 10) {
            System.out.println("Available options:");
            System.out.println("1 - the sum of integers");
            System.out.println("2 - the difference of integers");
            System.out.println("3 - the product of integers");
            System.out.println("4 - the average of integers");
            System.out.println("5 - the distance(the difference between integers)");
            System.out.println("6 - the maximum(the larger of integers)");
            System.out.println("7 - the minimum(smaller of integers)");
            System.out.println("8 - turn the session down");
            System.out.println("Choose the option:");
            int myInt = 0;
            try {
                myInt = keyboard.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Sorry, there was a problem:(");
            }
            switch (myInt) {
                case 1:
                    System.out.println(summingMethod(firstInteger, secondInteger));
                    break;
                case 2:
                    System.out.println(differenceMethod(firstInteger, secondInteger));
                    break;
                case 3:
                    System.out.println(productMethod(firstInteger, secondInteger));
                    break;
                case 4:
                    System.out.println(averageMethod(firstInteger, secondInteger));
                    break;
                case 5:
                    System.out.println(distanceMethod(firstInteger, secondInteger));
                    break;
                case 6:
                    System.out.println(Math.max(firstInteger, secondInteger));
                    break;
                case 7:
                    System.out.println(Math.min(firstInteger, secondInteger));
                    break;
                case 8:
                    condition = 5;
                    System.out.println("Bye!Have a nice day:)");
                    break;
                default:
                    System.out.println("Try another key, please.");
                    break;
            }
        }
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

    public static int distanceMethod(int firstInteger, int secondInteger) {
        return Math.abs(firstInteger - secondInteger);
    }
}
