package com.hillel.elementary.oleh.taskJg19;

public class Task_19
{
    public static void main(String[] args)
    {

    int a=0, b=1000;
    int n = a + (int) (Math.random() * b);
        System.out.println("random = " + n);
    int sum = 0;
while (n !=0)
     {
        //Суммирование цифр числа
        sum += (n % 10);
        n /= 10;
     }
        System.out.println("SUM = " + sum);
    }
}
