package com.hillel.elementary.javageeks.oleg.my_labs.collection;

import java.util.TreeSet;

public class NumnerStorageStructure {
    TreeSet<Integer> treeSet;

    public NumnerStorageStructure(TreeSet<Integer> treeSet) {
        this.treeSet = treeSet;
    }

    public boolean addElement(Integer element) {
        return treeSet.add (element);
    }

    public  boolean deleteElement(Integer element) {
        treeSet.remove (element);
        return true;
    }


    public Integer findElement( Integer element) {
        Integer higherElement=treeSet.higher (element);
        Integer lowerElement=treeSet.lower (element);
        if ((higherElement-element)<(element-lowerElement)){
            return higherElement;
        }else{
            return lowerElement;
        }
    }
}

