package com.hillel.elementary.javageeks;

public class Stoarray {
    public static void main(String[] args) {

        int[] arr = new int[100];

        int count = 0;

        for(int i = 12;count < 100;i++){
            if (i % 13 == 0 || i % 17 ==0){
                arr[count] = i;
                count++;
            }
        }
        for (int q:arr){
            System.out.print(q + ",");
        }

    }
}
