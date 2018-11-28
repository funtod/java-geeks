package com.hillel.elementary.javageeks.examples.collections;

import java.util.*;

public class MyArrayList implements List<Object> {

    private final static int INITIAL_CAPACITY = 16;

    private Object[] storage;
    private int size = 0;

    public MyArrayList() {
        this(INITIAL_CAPACITY);
    }

    public MyArrayList(int capacity) {
        storage = new Object[capacity];
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
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            Object element = storage[i];
            if (elementsAreEqual(o, element)) return true;
        }
        return false;
    }

    @Override
    public Iterator<Object> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(storage, size);
    }

    @Override
    public boolean add(Object o) {
        ensureCapasity(size + 1);
        storage[size++] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            Object element = storage[i];

            if (element == null) {
                if (o == null) {
                    removeAndDecrementSize(i);
                    return true;
                }
            } else if (element.equals(o)) {
                removeAndDecrementSize(i);
                return true;
            }
        }
        return false;
    }

    private void removeAndDecrementSize(int i) {
        int sizeToCopy = size - i - 1;
        System.arraycopy(storage, i + 1, storage, i, sizeToCopy);
        storage[--size] = null;
    }

    @Override
    public boolean containsAll(Collection<?> otherCollection) {
        if (otherCollection == null) return false;

        for (Object other : otherCollection) {
            if (!contains(other)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<?> otherCollection) {
        boolean everythingIsAdded = true;
        for (Object obj : otherCollection) {
            if (!add(obj)) everythingIsAdded = false;
        }
        ;
        return everythingIsAdded;
    }

    @Override
    public boolean addAll(int index, Collection<?> otherCollection) {
        if (otherCollection == null) return false;

        int sizeToInsert = otherCollection.size();
        ensureCapasity(sizeToInsert + this.size);
        Object[] otherArray = otherCollection.toArray();
        System.arraycopy(storage, index, storage, index + sizeToInsert, sizeToInsert);
        System.arraycopy(otherArray, 0, storage, index, sizeToInsert);
        size = size + sizeToInsert;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> otherCollection) {
        if (otherCollection == null) return false;
        boolean isAllDeleted = true;
        for (Object obj : otherCollection) {
            if (!remove(obj)) isAllDeleted = false;
        }
        return isAllDeleted;
    }

    private void ensureCapasity(int sizeToCheck) {
        if (sizeToCheck == storage.length) {
            storage = Arrays.copyOf(storage, 2 << storage.length);
        }
    }

    @Override
    public boolean retainAll(Collection<?> otherCollection) {
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index >= size) throw new IllegalArgumentException("");
        return storage[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            Object element = storage[i];
            if (elementsAreEqual(o, element)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size; i >= 0; i--) {
            Object element = storage[i];
            if (elementsAreEqual(o, element)) return i;
        }
        return -1;
    }

    private boolean elementsAreEqual(Object o, Object element) {
        if (element == null) {
            return o == null;
        } else return element.equals(o);
    }

    @Override
    public ListIterator<Object> listIterator() {

        return null;
    }

    @Override
    public ListIterator<Object> listIterator(int index) {
        return null;
    }

    @Override
    public List<Object> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList objects = (MyArrayList) o;
        return size == objects.size &&
                Arrays.equals(storage, objects.storage);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(storage);
        return result;
    }


    class MyIterator implements Iterator {
        int pointer = 0;

        @Override
        public boolean hasNext() {
            return pointer < size;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return storage[pointer++];
            } else {
                throw new NoSuchElementException();
            }
        }
    }

}
