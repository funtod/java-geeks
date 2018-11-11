package Homework3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a,b,c,D,d,x1,x2 ;
        System.out.println("ax^2+bx+c = 0");
        System.out.print("Enter a: ");
        a = scanner.nextDouble();
        System.out.print("Enter b: ");
        b = scanner.nextDouble();
        System.out.print("Enter c: ");
        c = scanner.nextDouble();
        D = b*b-4*a*c;
        d = Math.sqrt(D);
        x1 = (-b+d)/2*a;
        x2 = (-b-d)/2*a;
        System.out.println();
        System.out.println("x1 = "+ x1 +"  x2 = "+x2);
    }
}
