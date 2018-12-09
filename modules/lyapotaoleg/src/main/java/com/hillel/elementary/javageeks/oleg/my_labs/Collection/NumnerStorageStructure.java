package com.hillel.elementary.javageeks.oleg.my_labs.Collection;

import java.util.Iterator;

public class NumnerStorageStructure {

    private MyCollection myCollection;

    public NumnerStorageStructure(MyCollection myCollection) {
        this.myCollection = myCollection;
    }

    public void addElement(Integer element) {
        myCollection.add (element);
    }

    public void deleteElement(Integer element) {
        myCollection.remove (element);
    }

    public Integer findElement(Integer element) {
        Iterator<Integer> iterator=myCollection.iterator ();
        Integer min=(Integer) iterator.next ();

        while (iterator.hasNext ()) {
            Integer number=(Integer)iterator.next ();
            if (Math.abs(number-element)<Math.abs(min-element));
            min=number;
        }
        return min;
    }
}
