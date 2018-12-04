package com.hillel.elementary.javageeks.examples.collections;

import java.util.*;

public class SimplePriorityQueue implements Queue {

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    private Object[] storage;
    private Comparator comparator;

    public SimplePriorityQueue() {
        this(null);
    }

    public SimplePriorityQueue(Comparator comparator) {
        this.comparator = comparator;
        this.storage = new Object[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object element) {
        if (element == null) {
            return false;
        }
        checkSize(size + 1);

        storage[size] = element;
        if (size == 0) {
            storage[0] = element;
        } else {
            shiftUp(element);
        }

        size++;
        return true;
    }

    private void shiftUp(Object element) {
        if (comparator != null) {
            shiftUpWithComparator(element);
        } else {

        }
    }

    private void shiftUpWithComparator(Object element) {
        int index = size;

        for (int parentIndex = (index - 1) / 2; index > 0; parentIndex = (index - 1) / 2) {
            if (comparator.compare(element, storage[parentIndex]) > 0) {
                storage[index] = storage[parentIndex];
                index = parentIndex;
            } else {
                break;
            }
        }
        storage[index] = element;
    }


    private void checkSize(int newSize) {
        if (storage.length == newSize) {
            storage = Arrays.copyOf(storage, storage.length * 2);
        }
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean offer(Object element) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        if (size == 0) {
            return null;
        }

        Object element = storage[0];
        storage[0] = storage[--size];
        storage[size] = null;

        siftDown();


        return element;
    }

    private void siftDown() {

        if (comparator != null) {
            siftDownWithComparator();
        } else {
            
        }

    }

    private void siftDownWithComparator() {
        Object element = storage[0];
        int index = 0;

        for (; index < size / 2; ) {
            int childIndex = index  * 2 + 1;
            int rightChildIndex = index * 2 + 2;

            Object child = storage[childIndex];

            if (storage[rightChildIndex] != null
                    && comparator.compare(storage[rightChildIndex], child) > 0) {
                child = storage[rightChildIndex];
                childIndex = rightChildIndex;
            }

            if (comparator.compare(child, element) > 0) {
                storage[index] = child;
                index = childIndex;
            } else {
                break;
            }
        }

        storage[index] = element;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
