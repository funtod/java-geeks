package com.hillel.elementary.javageeks.ruslanTask2;

import java.util.*;

/*
Ввести n чисел с консоли.
Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 */

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length: ");
        int lenArr=sc.nextInt();
        String[] arrStr = new String[lenArr];
        String[] OutArr = new String[lenArr];

        System.out.println("Enter array value:");
        int arrVal=0;
        while ( arrVal<arrStr.length){
            arrStr[arrVal]=sc.next();
            arrVal++;
        }

        for (int i = 0; i < arrStr.length; i++) {
            char[] arrCha = arrStr[i].toCharArray();
            if (checkUniq(arrCha)==true) {
                OutArr[i]=arrStr[i];
            }

        }

        for (String number : OutArr) {
            if (number!=null) {
                System.out.println("Number " + number + " consist of different digits");
                break;
            }
        }
    }
    public static boolean checkUniq(char[] arrList) {
        for(int i=0; i < arrList.length; i++) {
            for(int j=i+1; j < arrList.length; j++) {
                if(arrList[i] == arrList[j]) {
                    return false;
                }
            }

        }
        return true;

    }
}