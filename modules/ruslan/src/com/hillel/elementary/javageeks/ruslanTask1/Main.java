package com.hillel.elementary.javageeks.ruslanTask1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Please enter number from 1 to 7");
            while (!sc.hasNextInt()) {//check before int value will be input
                System.out.println("Please enter number from 1 to 7");
                sc.next();//promt value
            }
            number = sc.nextInt();
        } while (number <= 0);//check positive value
        switch(number){
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Not a valid day");
                sc.close();
        }
    }
}