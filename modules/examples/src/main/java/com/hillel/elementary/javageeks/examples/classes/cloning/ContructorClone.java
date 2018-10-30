package com.hillel.elementary.javageeks.examples.classes.cloning;

import java.util.EmptyStackException;

public class ContructorClone {
    private Log[] elements;
    private int size = 0;

    public ContructorClone(int initialCapacity) {
        this.elements = new Log[initialCapacity];
    }

    public ContructorClone(ContructorClone original) { // мы знаем какой тип вернется
        this.elements = new Log[original.size];
        for(int i = 0; i < size; i++) {
            Log element = new Log();
            element.setLength(original.elements[i].getLength());
            this.elements[i] = element;
        }
    }

    public void push(Log e) {
        elements[size ++] = e;
    }

    public Log pop() {
        if (size == 0) throw new EmptyStackException();
        Log result = elements[- size];
        elements[size] = null; // Убираем устаревшую ссылку
        return result;
    }

}
