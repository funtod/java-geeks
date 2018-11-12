package com.hillel.elementary.javageeks.oleg.my_labs.lab_2;

import java.util.Scanner;

public class Numbers {
    // немного усложнил условия: пользователь вводит конечное число до которого искать числа
    // массив на 100 элементов создается, заполняется числами которые делятся на 13 или на 17
    // когда массив заполнен работа программы прекращается автоматически
    public static void main(String[] args) {
        int mus []=new int[100];
        int count=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите граничное число до которого будут искаться числа, которые делятся на 13 и на 17");
        int number=scanner.nextInt();
        scanner.close();
        for (int i=1; i<number; i++){
           if (i%13==0 || i%17==0){
               mus[count]=i;
               count++;
               if (count==100) break;
           }
        }
        System.out.print("Массив из 100 чисел которые делятся на 13 и на 17 с граничным числом " +number + " выглядит так: ");
        for (int numbers : mus){
            System.out.print(numbers+" ");
        }
    }
}
