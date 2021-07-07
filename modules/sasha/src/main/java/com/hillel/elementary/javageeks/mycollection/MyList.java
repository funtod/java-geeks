package com.hillel.elementary.javageeks.mycollection;

import java.util.LinkedList;

public class MyList {

    public static LinkedList actMatrix(int[][] arrOne,int[][] arrTwo,String argument){
        LinkedList<Integer> listFist = matrixToList(arrOne);
        LinkedList<Integer> listSecond = matrixToList(arrTwo);

        LinkedList listResult = actList(listFist, listSecond,argument);
        return listResult;

    }

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
    
    private static LinkedList actList(LinkedList<Integer> listOne,LinkedList<Integer> listTwo,String argument){
        LinkedList list = new LinkedList();
        int minSize = 0;
        if(listOne.size() <= listTwo.size()){
            minSize = listOne.size();
        }
        else {
            minSize = listTwo.size();
        }

        if(argument == "sum") {
            for (int i = 0; i < minSize; i++) {
                list.add(listOne.get(i) + listTwo.get(i));
            }
            return list;
        }
        if(argument == "multiply"){
            for(int i = 0;i < minSize;i++){
                list.add(listOne.get(i) * listTwo.get(i));
            }
            return list;
        }
        return list;
    }

}
