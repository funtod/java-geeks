package com.hillel.elementary.javageeks.oleg.my_labs.Collection;

import java.util.*;

public class MyCollection extends TreeSet {

    MyCollection myCollection;

    public boolean addElement(Integer element) {
        return myCollection.add (element);

    }

    public boolean deleteElement(Integer element) {
        myCollection.remove (element);
        return true;
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
