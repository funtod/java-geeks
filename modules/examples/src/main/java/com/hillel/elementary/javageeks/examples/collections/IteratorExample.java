package com.hillel.elementary.javageeks.examples.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorExample {


    public Iterable reverse(Iterable iterable) {

        LinkedList list = new LinkedList();
        Iterator iterator = iterable.iterator();
        while(iterator.hasNext()) {
            Object next = iterator.next();
            list.addLast(next);
        }

        return list;
    }
}
