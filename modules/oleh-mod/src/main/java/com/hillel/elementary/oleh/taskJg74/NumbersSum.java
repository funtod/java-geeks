package com.hillel.elementary.oleh.taskJg74;
import  java.util.Scanner;
public class NumbersSum {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую строку: ");
        String str = scanner.next();

        if (!str.matches("^\\D*$")) {
            System.out.println("STR cодержит цифры!");
        } else {
            System.out.println("STR не содержит цифр!");
        }

        int count = 0, sum=0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                count++;
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }

        if ((count >= 1) && (sum >= 1)) {
            System.out.println("STR содержит " + count + " цифр и их сумма = " + sum);
        } else {
            System.out.println("STR не содержит цифр, невозможно вычислить сумму!");
        }
    }
}
