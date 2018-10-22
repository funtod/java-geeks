package com.hillel.elementary.javageeks.mostipan.task1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double meters;
        boolean again = true;
        while (again) {
            System.out.println("Введите дюймы:");
            Scanner inches = new Scanner(System.in);
            if (inches.hasNextDouble()) {
                meters = inches.nextDouble()/39.37;
                System.out.println("Метры : " + meters);
            }
                else {
                     try {
                         meters = Double.parseDouble(inches.nextLine())/39.37;
                         System.out.println("Метры: " + meters);
                        } catch (Exception e) {
                         System.out.println("Неверное значение ");
                     }
                }
            System.out.println("Чтобы продолжить введите Y:");
                if (!inches.next().equalsIgnoreCase("Y")){
                    again = false;
                }
            }
        }
    }
