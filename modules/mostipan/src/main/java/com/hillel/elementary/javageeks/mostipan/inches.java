package com.hillel.elementary.javageeks.mostipan;

import java.util.Scanner;

public class inches {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in) ;
        System.out.println("Введите дюймы");
        double inch = k.nextDouble();
            double metres = inch/39.37 ;
        System.out.println("Метры = " + metres);
    }
}
