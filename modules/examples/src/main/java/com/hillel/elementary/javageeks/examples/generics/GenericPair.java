package com.hillel.elementary.javageeks.examples.generics;

import java.util.Comparator;

public class GenericPair<S, T> implements Comparator<GenericPair<S,T>> {
    private S first;
    private T second;

    public GenericPair(S first, T second) {
        this.first = first;
        this.second = second;
    }

    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }


    @Override
    public int compare(GenericPair<S, T> o1, GenericPair<S, T> o2) {
        return 0;
    }
}
