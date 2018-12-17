package com.hillel.elementary.oleh.taskJg4;

import java.util.ArrayList;
import java.util.Scanner;

public class RandomMatrix  {


     public static int matrixSize() {
        System.out.println("matrix size (size > 0)=" );
        Scanner size = new Scanner(System.in);
        int numberSize = size.nextInt();
        while (numberSize <= 0 )
        {
            System.out.println("You are Wrong ");
            numberSize = size.nextInt();
        }

        return numberSize;
    }

    

    public static int [][] matrixRange(int size  ) {
        System.out.print("Range for matrix " + "\n start from " );
        Scanner  range = new Scanner(System.in);
        int rangeStart = range.nextInt();
        System.out.println("to " );
        int rangeFinish = range.nextInt();
        int randome;

        int [][] array = new int  [size][size];
        for (int i = 0; i <array.length; i++) {
            for (int j = 0; j <array[i].length; j++) {
                randome = rangeStart + (int) (Math.random() * rangeFinish);
                array[i][j] =  randome;
            }
        }
        return array;
    }

     public static Object matrixOperation(int size , int angle) {
        int arrayRotate[][] = matrixRange(size);
        System.out.println("Angle = 0");
        for (int i = 0; i < arrayRotate.length; i++) {
            for (int j = 0; j < arrayRotate[i].length; j++) {  //стандартна матриця
                System.out.print("  " + arrayRotate[i][j]);
            }
            System.out.println();
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < arrayRotate.length; i++) {
            for (int j = 0; j < arrayRotate[i].length; j++) {//двохмірного масива в ерейліст
                arrayList.add(arrayRotate[i][j]);
            }
        }

        int arrayIndex = size;
         System.out.println(size + "  size " + angle + "  angle  "  + arrayList + "  arrayList  "
                 + arrayIndex + "  arrayIndex  " +  "  arrayRotate  ");
       return matrix(size, angle,  arrayList, arrayIndex , arrayRotate);
    }

    public static Object returnMatrixMethod(int size, ArrayList<Integer> partList, int[][] arrayRotate, int angle){

        int q=0;
        for (int i = 0; i <size; i++) {
            for (int j = 0; j <size ; j++) {

                arrayRotate[i][j] = partList.get(q);
                q=q+1;
            }

        }

        System.out.println("matrix  Angle =  " + angle);
        for (int i = 0; i < arrayRotate.length; i++) {
            for (int j = 0; j < arrayRotate[i].length; j++) { //перевод ерейліста в двохмірний масив
                System.out.print("  " + arrayRotate[i][j]);
            }
            System.out.println();
        }
        return  true;
    }

    public static Object matrix(int size, int angle,  ArrayList<Integer> arrayList, int arrayIndex, int[][] arrayRotate) {
        ArrayList<Integer> partList = new ArrayList<Integer>();
         switch (angle){
            case 1: {
                for (int i = 0; i <size; i++) {
                    for (int j = 0; j <size ; j++) {
                        partList.add(arrayList.get(arrayIndex -1 -i )); //поворот на 90 градусів
                        arrayIndex=arrayIndex+size;

                    }
                    arrayIndex = size;
                }
                break;
            }
            case 2:{
                int tmp =0;
                for (int i = 0; i <arrayList.size(); i++) {

                        partList.add(arrayList.get(arrayList.size() -1 -tmp )); //поворот на 180 градусів
                    tmp ++;
                }
                break;
            }
            case 3:{
                for (int i = 0; i <size; i++) {

                    for (int j = 0; j <size ; j++) {
                        partList.add(arrayList.get(arrayList.size() -arrayIndex  +i )); //поворот на 270 градусів
                        arrayIndex=arrayIndex+size;
                    }
                    arrayIndex = size;
                }
                break;

            }
        }

     return returnMatrixMethod(size ,partList ,arrayRotate, angle);
    }

   public static void martixAngle() {
        Scanner angle1 = new Scanner(System.in);
        System.out.println("Angle: \n1.90\n2.180\n3.270");
        int angle = angle1.nextInt();
        while (angle <= 0 && angle <4 )
        {
            System.out.println("You Wrong ");
            angle = angle1.nextInt();
        }

         matrixOperation(matrixSize() , angle);

    }

    public static void main(String[] args) {
        martixAngle();
    }
}
