package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurentHashMapExample {

    public static void main(String[] args) {
        //ConcurrentHashMap
        Map<String,String> myMap = new ConcurrentHashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("ConcurrentHashMap перед итератором: "+myMap);
        Iterator<String> it = myMap.keySet().iterator();

        while(it.hasNext()){
            String key = it.next();
            if(key.equals("3")) myMap.put(key+"new", "new3");
        }
        System.out.println("ConcurrentHashMap после итератора: "+myMap);

        //HashMap
        myMap = new HashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("HashMap перед итератором: "+myMap);
        Iterator<String> it1 = myMap.keySet().iterator();

        while(it1.hasNext()){
            String key = it1.next();
            if(key.equals("3")) myMap.put(key+"new", "new3");
        }
        System.out.println("HashMap после итератора: "+myMap);
    }
}
