package com.hillel.elementary.oleh.task_jg_4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomMatrix {

    protected static int matrixSize()
    {
        System.out.println("matrix size (0-5)=" );
        Scanner size = new Scanner(System.in);
        int numberSize = size.nextInt();
        if (numberSize < 0 || 5  < numberSize  ){
            System.out.println("You Wrong ");
            matrixSize();
        }
        //if (numberSize <6 && numberSize >0 )
        int n = numberSize;
        return numberSize;

    }

    protected static int [][] matrixRange (){
        System.out.println("Range for matrix " + "\nfirst " );
        Scanner  a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        int a1 = a.nextInt();
        System.out.println("second" );
        int b1 = b.nextInt();
        int n ;

        int size = matrixSize();
        int [][] array = new int  [size][size];
        for (int i = 0; i <array.length; i++) {
            for (int j = 0; j <array[i].length; j++) {
                n = a1 + (int) (Math.random() * b1);
                array[i][j] =  n;

            }
        }


        return array;
    }
    protected    static void  matrixStandart(){
        int arrays [][] = matrixRange();
        for (int i = 0; i <arrays.length; i++) {
            for (int j = 0; j <arrays[i].length; j++) {

                System.out.print("  " + arrays[i][j]);
            }
            System.out.println();
        }
    }

    protected static void martixAngle() {
        Scanner angle1 = new Scanner(System.in);
        System.out.println("Angle: \n1.90\n2.180\n3.270");
        int angle = angle1.nextInt();
        if(0 < angle && angle< 4 ){
            int arrayRotate [][] = matrixRange();
        switch (angle){
            case 1:
            {
                System.out.println("Angle = 0");
                for (int i = 0; i < arrayRotate.length; i++) {
                    for (int j = 0; j < arrayRotate[i].length; j++) { //стандартна матриця
                        System.out.print("  " + arrayRotate[i][j]);
                    }
                    System.out.println();
                }


                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                int n = matrixSize();
                ArrayList<Integer> partList = new ArrayList<Integer>();


                for (int i = 0; i < arrayRotate.length; i++) {
                    for (int j = 0; j < arrayRotate[i].length; j++) {//двохмірного масива в ерейліст
                        arrayList.add(arrayRotate[i][j]);
                    }
                }

                int arrayIndex =n;
                //System.out.println(arrayList + " size = " + n  + " arrays index =" + arrayIndex);
                for (int i = 0; i <n; i++) {

                    for (int j = 0; j <n ; j++) {
                        partList.add(arrayList.get(arrayIndex -1 -i )); //поворот на 90 градусів
                        arrayIndex=arrayIndex+n;

                    }
                    arrayIndex = n;
                }
                int q=0;
                for (int i = 0; i <n; i++) {
                    for (int j = 0; j <n ; j++) {

                        arrayRotate[i][j] = partList.get(q);
                        q=q+1;
                    }

                }
                //System.out.println("partlist = " + partList); //ерей ліст

                System.out.println("matrix  Angle= 90 ");
                for (int i = 0; i < arrayRotate.length; i++) {
                    for (int j = 0; j < arrayRotate[i].length; j++) { //перевод ерейліста в двохмірний масив
                        System.out.print("  " + arrayRotate[i][j]);
                    }
                    System.out.println();
                }
                break;
            }





            case 2:{
                System.out.println("Angle = 0");

                for (int i = 0; i <arrayRotate.length; i++) {
                    for (int j = 0; j <arrayRotate[i].length; j++) {
                        System.out.print("  " + arrayRotate[i][j]);
                    }   System.out.println(); }

                System.out.println("angle180 ");
                for (int i = arrayRotate.length - 1 ; i >= 0; i--) {
                    for (int j = 0; j <arrayRotate[i].length; j++) {
                        int arrayRotate180[][]  = arrayRotate;
                        System.out.print("  " + arrayRotate180[i][j]);
                    }   System.out.println(); }

                break;
            }
            case 3:{
                for (int i = 0; i < arrayRotate.length; i++) {
                    for (int j = 0; j < arrayRotate[i].length; j++) { //стандартна матриця
                        System.out.print("  " + arrayRotate[i][j]);
                    }
                    System.out.println();
                }


                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                int n = matrixSize();
                ArrayList<Integer> partList = new ArrayList<Integer>();


                for (int i = 0; i < arrayRotate.length; i++) {
                    for (int j = 0; j < arrayRotate[i].length; j++) {//двохмірного масива в ерейліст
                        arrayList.add(arrayRotate[i][j]);
                    }
                }

                int arrayIndex =n;
                //System.out.println(arrayList + " size = " + n  + " arrays index =" + arrayIndex);
                for (int i = 0; i <n; i++) {

                    for (int j = 0; j <n ; j++) {
                        partList.add(arrayList.get(arrayList.size() -arrayIndex  +i )); //поворот на 270 градусів
                        arrayIndex=arrayIndex+n;

                    }
                    arrayIndex = n;
                }
                int q=0;
                for (int i = 0; i <n; i++) {
                    for (int j = 0; j <n ; j++) {

                        arrayRotate[i][j] = partList.get(q);
                        q=q+1;
                    }

                }
                //System.out.println("partlist = " + partList); //ерей ліст

                System.out.println("matrix  Angle= 270 ");
                for (int i = 0; i < arrayRotate.length; i++) {
                    for (int j = 0; j < arrayRotate[i].length; j++) { //перевод ерейліста в двохмірний масив
                        System.out.print("  " + arrayRotate[i][j]);
                    }
                    System.out.println();
                }
                break;
            }
        }

    }}

    public static void main(String[] args) {

        martixAngle();
    }

}
