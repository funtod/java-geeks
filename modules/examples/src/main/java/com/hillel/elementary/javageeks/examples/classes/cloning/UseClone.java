package com.hillel.elementary.javageeks.examples.classes.cloning;

import java.util.EmptyStackException;

public class UseClone implements Cloneable {
    private Object[] elements;
    private int size = 0;

    public UseClone(int initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    public void push(Object e) {
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Убираем устаревшую ссылку
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        UseClone clone = (UseClone) super.clone();
        // не будет работать, если у elements стоит модификатор final
        clone.elements = elements.clone(); //неглубокое клонирование. При глубоком мы будет делать клонирование в цикле
        return clone;
    }
}
