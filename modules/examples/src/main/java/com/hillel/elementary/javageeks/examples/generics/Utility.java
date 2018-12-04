package com.hillel.elementary.javageeks.examples.generics;

import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Utility {

    private Utility() {}

    public static <T, E extends T> T fill(List<T> list, E val) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, val);
        return val;
    }

    public static <T> void revert(List<T> list) {
        int size = list.size();
        if (list instanceof RandomAccess) {
            for (int i=0, mid=size>>1, j=size-1; i<mid; i++, j--)
                swap(list, i, j);
        } else {
            ListIterator<T> fwd = list.listIterator();
            ListIterator<T> rev = list.listIterator(size);
            for (int i=0, mid=list.size()>>1; i<mid; i++) {
                T tmp = fwd.next();
                fwd.set(rev.previous());
                rev.set(tmp);
            }
        }
    }

    private static <T> void swap(List<T> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

}
