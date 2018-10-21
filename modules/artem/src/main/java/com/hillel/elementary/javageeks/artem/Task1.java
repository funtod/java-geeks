package com.hillel.elementary.javageeks.artem;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double F,C ;
        System.out.print("Enter temperature(F): ");
        F = s.nextDouble();
        C = (F-32)*5/9;
        System.out.println(F+" F = "+C+" C");
    }
}
