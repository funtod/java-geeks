package com.hillel.elementary.javageeks.ruslanTask1;

import java.util.Scanner;

public class DayOfWeekPrinter {

    public void printDayOfWeek () {
        int number = readUserInput();
        String dayName = printDayName (number);
        System.out.println(dayName);
    }

    private String printDayName (int number) {
        switch(number){
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return "Not a valid day";


        }
    }

    private int readUserInput () {
        Scanner sc = new Scanner(System.in);
        int number;
        try {
            do {
                System.out.println("Please enter number from 1 to 7");
                while (!sc.hasNextInt()) {//check before int value will be input
                    System.out.println("Please enter number from 1 to 7");
                    sc.next();//promt value
                }
                number = sc.nextInt();
            } while (number <= 0);//check positive value
        } finally {
            sc.close();
        }
        return number;
    }

}
