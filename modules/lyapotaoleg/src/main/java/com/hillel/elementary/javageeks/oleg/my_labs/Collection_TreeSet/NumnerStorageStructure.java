package com.hillel.elementary.javageeks.oleg.my_labs.Collection_TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class NumnerStorageStructure {

    public NumnerStorageStructure() {
    }

    public static boolean addElement(TreeSet<Integer> treeSet, Integer element) {
        return treeSet.add (element);
    }

    public static boolean deleteElement(TreeSet<Integer> treeSet,Integer element) {
        treeSet.remove (element);
        return true;
    }

    public static Integer findElement(TreeSet<Integer> treeSet, Integer element) {
        Iterator<Integer> iterator=treeSet.iterator ();
        Integer min=(Integer) iterator.next ();

        while (iterator.hasNext ()) {
            Integer number=(Integer)iterator.next ();
            if (Math.abs(number-element)<Math.abs(min-element)){
                min=number;
            }
        }
        System.out.println (min);
        return min;
    }
}
