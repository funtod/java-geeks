package com.hillel.elementary.javageeks.examples.generics;

import java.util.Comparator;

public class Seq<T> {
    T element;
    Seq<T> next;

    public Seq(T element, Seq<T> next) {
        this.element = element;
        this.next = next;
    }

//    public void sort(Comparator<T> comp) {/*...*/ } // Alt. (1)

    public void sort(Comparator<? super T> comp) {/*...*/ } // Alt. (2)

//    public void sort(Comparator<? extends T> comp) {/*...*/ } // Alt. (3)

    public static void main(String[] args) {
        Seq<String> strSeq = new Seq<String>("aha", new Seq<String>("aho", null));
        strSeq.sort(String.CASE_INSENSITIVE_ORDER); // Comparator<String> is ok for (1) and (2).
        strSeq.sort(new Comparator<Object>() {        // Comparator<Object> is not ok for (1) and but is ok for (2).
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }
}


