package com.hillel.elementary.javageeks.dir.concurrency.atomics;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleNonBlockingQueue<T> extends AbstractQueue<T> {


    private AtomicReference<Node<T>> head = new AtomicReference<>(null);
    private AtomicInteger size = new AtomicInteger(0);


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size.get();
    }

    @Override
    public boolean offer(T value) {
        if (value == null) throw new IllegalArgumentException();

        while (true) {
            Node<T> first = head.get();
            Node<T> node = new Node<>(value, first);

            if (head.compareAndSet(first, node)) {
                return true;
            }
        }
    }

    @Override
    public T poll() {
        if (head.get() == null) return null;

        while(true) {



        }
    }

    @Override
    public T peek() {
        return null;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
