package com.hillel.elementary.javageeks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("enter a number,please");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Square of number = "+ number*number);
        System.out.println("Cube number ="+ number*number*number);
        System.out.println("fourth degree number ="+number*number*number*number);
    }
}






