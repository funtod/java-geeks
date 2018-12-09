package com.hillel.elementary.javageeks.mycollection;

import java.util.LinkedList;

public class MyList {
    private static LinkedList matrixToList(int[][] arr){
        LinkedList list = new LinkedList();
        for (int i = 0;i < arr.length;i++){
            for (int k = 0;k < arr[0].length;k++){
                if(arr[i][k] != 0){
                    list.add(arr[i][k]);
                }
            }
        }
        return list;
    }
    private static LinkedList sumList(LinkedList<Integer> listOne,LinkedList<Integer> listTwo){
        LinkedList list = new LinkedList();
        int minSize = 0;
        if(listOne.size() <= listTwo.size()){
            minSize = listOne.size();
        }
        else {
            minSize = listTwo.size();
        }


        for(int i = 0;i < minSize;i++){
            list.add(listOne.get(i) + listTwo.get(i));
        }
        return list;
    }
    private static LinkedList multiplyList(LinkedList<Integer> listOne,LinkedList<Integer> listTwo){
        LinkedList list = new LinkedList();
        int minSize = 0;
        if(listOne.size() <= listTwo.size()){
            minSize = listOne.size();
        }
        else {
            minSize = listTwo.size();
        }

        for(int i = 0;i < minSize;i++){
            list.add(listOne.get(i) * listTwo.get(i));
        }
        return list;
    }

    public static LinkedList sumMatrix(int[][] arrOne,int[][] arrTwo){
        LinkedList<Integer> listFist = matrixToList(arrOne);
        LinkedList<Integer> listSecond = matrixToList(arrTwo);

        LinkedList listResult = sumList(listFist, listSecond);

        return listResult;

    }
    public static LinkedList multyplyMatrix(int[][] arrOne,int[][] arrTwo){
        LinkedList<Integer> listFist = matrixToList(arrOne);
        LinkedList<Integer> listSecond = matrixToList(arrTwo);

        LinkedList listResult = multiplyList(listFist,listSecond);

        return listResult;

    }



}
